package com.kaiasia.app.repository;

import com.kaiasia.app.core.dao.CommonDAO;
import com.kaiasia.app.core.dao.PosgrestDAOHelper;
import com.kaiasia.app.entity.FundTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.HashMap;
import java.util.Map;

public class FundTransferDAO extends CommonDAO implements IFundTransferDAO {
    @Autowired
    private PosgrestDAOHelper posgrestDAOHelper;

    public FundTransferDAO() {
    }

    public FundTransfer getByTokenKey(String transactionId) throws Exception {
        StringBuilder sql = (new StringBuilder("SELECT * FROM ")).append(this.getTableName()).append(" WHERE id = :transactionId ");
        Map<String, Object> param = new HashMap();
        param.put("transactionId", transactionId);
        return (FundTransfer)this.posgrestDAOHelper.querySingle(sql.toString(), param, new BeanPropertyRowMapper(FundTransfer.class));
    }

    public int insert(FundTransfer fundTransfer) throws Exception {
        StringBuilder sql = (new StringBuilder("INSERT INTO ")).append(this.getTableName()).append(" (").append("id, transaction_type, debit_acc, debit_ccy, debit_amt, credit_acc, credit_ccy, process_date, process_detail, co_code, ben_bank, ben_account, ben_name, channel, transaction_id, status)").append(" values (:id, :transaction_type, :debit_acc, :debit_ccy, :debit_amt, :credit_acc, :credit_ccy, :process_date, :process_detail, :co_code, :ben_bank, :ben_account, :ben_name, :channel, :transaction_id, :status) ");
        Map<String, Object> param = new HashMap();
        param.put("id", fundTransfer.getId());
        param.put("transaction_type", fundTransfer.getTransactionType());
        param.put("debit_acc", fundTransfer.getDebitAcc());
        param.put("debit_ccy", fundTransfer.getDebitCcy());
        param.put("debit_amt", fundTransfer.getDebitAmt());
        param.put("credit_acc", fundTransfer.getCreditAcc());
        param.put("credit_ccy", fundTransfer.getCreditCcy());
        param.put("process_date", fundTransfer.getProcessDate());
        param.put("process_detail", fundTransfer.getProcessDetail());
        param.put("co_code", fundTransfer.getCoCode());
        param.put("ben_bank", fundTransfer.getBenBank());
        param.put("ben_account", fundTransfer.getBenAccount());
        param.put("ben_name", fundTransfer.getBenName());
        param.put("channel", fundTransfer.getChannel());
        param.put("transaction_id", fundTransfer.getTransactionId());
        param.put("status", fundTransfer.getStatus());
        return this.posgrestDAOHelper.update(sql.toString(), param);
    }

    public boolean updateReverted(String id) throws Exception {
        StringBuilder sql = (new StringBuilder("UPDATE ")).append(this.getTableName()).append(" SET status = :status WHERE id = :id ");
        Map<String, Object> param = new HashMap();
        param.put("id", id);
        param.put("status", "01");
        return this.posgrestDAOHelper.update(sql.toString(), param) > 0;
    }
}
