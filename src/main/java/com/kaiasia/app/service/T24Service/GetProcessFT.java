package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.ProcessFTResponse;
import com.kaiasia.app.dto.Transaction;
import com.kaiasia.app.register.KaiMethod;
import com.kaiasia.app.register.KaiService;
import com.kaiasia.app.repository.DBService;
import ms.apiclient.model.ApiBody;
import ms.apiclient.model.ApiError;
import ms.apiclient.model.ApiRequest;
import ms.apiclient.model.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@KaiService
public class GetProcessFT extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;
    @Value("${mainBankCode}")
    private String mainBank;
    @Value("${napasNostro}")
    private String nostroNapas;

    public GetProcessFT() {
    }

    @KaiMethod(
            name = "KAI.API.FT.PROCESS",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        if (StringUtils.isBlank(transaction.getTransactionId())) {
            return this.getErrorUtils.getError("09", new String[]{"transactionId"});
        } else if (StringUtils.isBlank(transaction.getDebitAccount())) {
            return this.getErrorUtils.getError("09", new String[]{"debitAccount"});
        } else if (StringUtils.isBlank(transaction.getCreditAccount())) {
            return this.getErrorUtils.getError("09", new String[]{"creditAccount"});
        } else if (StringUtils.isBlank(transaction.getTransAmount())) {
            return this.getErrorUtils.getError("09", new String[]{"transAmount"});
        } else {
            try {
                Long.parseLong(transaction.getTransAmount());
            } catch (Exception var4) {
                return this.getErrorUtils.getError("09", new String[]{"transAmount"});
            }

            return StringUtils.isBlank(transaction.getTransDesc()) ? this.getErrorUtils.getError("09", new String[]{"transDesc"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
        }
    }

    @KaiMethod(
            name = "KAI.API.FT.PROCESS"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        ProcessFTResponse transactionNo = null;
        if (!this.mainBank.equals(transaction.getBankId())) {
            transaction.setCreditAccount(this.nostroNapas);
        }

        transactionNo = this.dbService.processFTInside(transaction);
        if (!ApiError.OK_CODE.equals(transactionNo.getError().getCode())) {
            apiRes.setError(transactionNo.getError());
            return apiRes;
        } else {
            Map<String, Object> trs = new HashMap();
            trs.put("transactionNo", transactionNo.getTransactionNo());
            trs.put("responseCode", "00");
            ApiBody apiBody = new ApiBody();
            apiBody.put("transaction", trs);
            apiRes.setBody(apiBody);
            return apiRes;
        }
    }
}
