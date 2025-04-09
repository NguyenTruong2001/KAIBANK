package com.kaiasia.app.repository;

import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.ProcessFTResponse;
import com.kaiasia.app.dto.Transaction;
import com.kaiasia.app.entity.*;
import ms.apiclient.model.ApiError;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Component
public class DBService {
    @Autowired
    private IEbankDAO ebankDAO;
    @Autowired
    private ICustomerDAO customerDAO;
    @Autowired
    private IAccountDAO accountDAO;
    @Autowired
    private IFundTransferDAO fundTransferDAO;
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private BanksDAO banksDAO;

    public DBService() {
    }

    public Ebank getUserByUsername(String u) throws Exception {
        return this.ebankDAO.getUserByUserName(u);
    }

    public Customer getCustomerById(String cId) throws Exception {
        return this.customerDAO.getByCusId(cId);
    }

    public List<Account> findAllByCustomerId(String cusId) throws Exception {
        return this.accountDAO.findAllByCustomerId(cusId);
    }

    public Account getAccountInfo(String accountId) throws Exception {
        return this.accountDAO.getAccountInfo(accountId);
    }

    public FundTransfer getFtByTokenKey(String token) throws Exception {
        return this.fundTransferDAO.getByTokenKey(token);
    }

    public int insertFundTransfer(FundTransfer fundTransfer) throws Exception {
        return this.fundTransferDAO.insert(fundTransfer);
    }

    @Transactional
    public ProcessFTResponse processFTInside(Transaction transaction) throws Exception {
        ProcessFTResponse apiRes = new ProcessFTResponse();
        BigDecimal amount = new BigDecimal(Long.parseLong(transaction.getTransAmount()));
        FundTransfer ftEd = this.fundTransferDAO.getByTokenKey(transaction.getTransactionId());
        if (ftEd != null) {
            ApiError apiError = this.getErrorUtils.getError("11");
            apiRes.setError(apiError);
            return apiRes;
        } else {
            Account account = this.accountDAO.getAccountForUpdate(transaction.getDebitAccount());
            ApiError apiError;
            if (account == null) {
                apiError = this.getErrorUtils.getError("06", new String[]{"debit#" + transaction.getDebitAccount()});
                apiRes.setError(apiError);
                return apiRes;
            } else if (!"ACTIVE".equals(account.getAccountStatus())) {
                apiError = this.getErrorUtils.getError("06", new String[]{"debit#" + transaction.getDebitAccount()});
                apiRes.setError(apiError);
                return apiRes;
            } else if (account.getBalance().compareTo(new BigDecimal(Long.parseLong(transaction.getTransAmount()))) < 0) {
                apiError = this.getErrorUtils.getError("10");
                apiRes.setError(apiError);
                return apiRes;
            } else {
                Account credit = this.accountDAO.getAccountForUpdate(transaction.getCreditAccount());
                ApiError apiError1;
                if (credit == null) {
                    apiError1 = this.getErrorUtils.getError("06", new String[]{"credit#" + transaction.getCreditAccount()});
                    apiRes.setError(apiError1);
                    return apiRes;
                } else if (!"ACTIVE".equals(credit.getAccountStatus())) {
                    apiError1 = this.getErrorUtils.getError("06", new String[]{"credit#" + transaction.getCreditAccount()});
                    apiRes.setError(apiError1);
                    return apiRes;
                } else {
                    BigDecimal newCredit = credit.getBalance().add(amount);
                    credit.setBalance(newCredit);
                    BigDecimal newDebit = account.getBalance().subtract(amount);
                    account.setBalance(newDebit);
                    FundTransfer fundTransfer = new FundTransfer();
                    fundTransfer.setId(this.createFt(account));
                    fundTransfer.setTransactionType("AC");
                    fundTransfer.setDebitAcc(account.getAltAcc());
                    fundTransfer.setDebitCcy(account.getCcy());
                    fundTransfer.setDebitAmt(amount);
                    fundTransfer.setCreditAcc(transaction.getCreditAccount());
                    fundTransfer.setCreditCcy(credit.getCcy());
                    fundTransfer.setProcessDate(new Date());
                    fundTransfer.setProcessDetail(transaction.getTransDesc());
                    fundTransfer.setCoCode(transaction.getCompany());
                    if (StringUtils.isBlank(fundTransfer.getCoCode())) {
                        fundTransfer.setCoCode(account.getCoCode());
                    }

                    fundTransfer.setBenBank(transaction.getBankId());
                    fundTransfer.setBenAccount(transaction.getBenAccount());
                    fundTransfer.setBenName(transaction.getBenName());
                    fundTransfer.setChannel(transaction.getChannel());
                    if (StringUtils.isBlank(fundTransfer.getChannel())) {
                        fundTransfer.setChannel("API");
                    }

                    fundTransfer.setTransactionId(transaction.getTransactionId());
                    if ("0123456789".equals(transaction.getCreditAccount())) {
                        Thread.sleep(60000L);
                        fundTransfer.setStatus("01");
                    } else {
                        if ("0987654321".equals(transaction.getCreditAccount())) {
                            Thread.sleep(60000L);
                            ApiError apiError2 = this.getErrorUtils.getError("999", new String[]{"TIMEOUT NO FT"});
                            apiRes.setError(apiError2);
                            return apiRes;
                        }

                        if ("01010101".equals(transaction.getCreditAccount())) {
                            fundTransfer.setStatus("00");
                            Thread.sleep(60000L);
                        } else {
                            fundTransfer.setStatus("00");
                        }
                    }

                    this.insertFundTransfer(fundTransfer);
                    this.accountDAO.update(account);
                    this.accountDAO.update(credit);
                    apiRes.setError(new ApiError(ApiError.OK_CODE, ApiError.OK_DESC));
                    apiRes.setTransactionNo(fundTransfer.getId());
                    return apiRes;
                }
            }
        }
    }

    private String createFt(Account debit) {
        return "FT".concat(Year.now().toString()).concat(debit.getAccId()).concat(String.valueOf(System.currentTimeMillis()));
    }

    public boolean updateFirstLogin(String username) throws Exception {
        try {
            return this.ebankDAO.updateFirstLogin(username);
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public List<BankCode> getBanks(String bankCode) throws Exception {
        return this.banksDAO.select(bankCode);
    }

    public boolean updatePassword(String newPass, String username) throws Exception {
        try {
            return this.ebankDAO.updatePassword(newPass, username);
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean updateReverted(String id) throws Exception {
        try {
            return this.fundTransferDAO.updateReverted(id);
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }
}
