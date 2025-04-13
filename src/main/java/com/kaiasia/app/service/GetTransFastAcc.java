package com.kaiasia.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.Transaction;
import com.kaiasia.app.register.KaiMethod;
import com.kaiasia.app.register.KaiService;
import com.kaiasia.app.repository.DBService;
import java.util.HashMap;
import java.util.Map;

import ms.apiclient.model.ApiBody;
import ms.apiclient.model.ApiError;
import ms.apiclient.model.ApiRequest;
import ms.apiclient.model.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@KaiService
public class GetTransFastAcc extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetTransFastAcc() {
    }

    @KaiMethod(
            name = "getTransFastAcc",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        if (StringUtils.isBlank(transaction.getSenderAccount())) {
            return this.getErrorUtils.getError("09", new String[]{"senderAccount"});
        } else if (StringUtils.isBlank(transaction.getAmount())) {
            return this.getErrorUtils.getError("09", new String[]{"amount"});
        } else {
            try {
                Long.parseLong(transaction.getAmount());
            } catch (Exception var4) {
                return this.getErrorUtils.getError("09", new String[]{"amount"});
            }

            if (StringUtils.isBlank(transaction.getCcy())) {
                return this.getErrorUtils.getError("09", new String[]{"ccy"});
            } else if (StringUtils.isBlank(transaction.getTransRef())) {
                return this.getErrorUtils.getError("09", new String[]{"transRef"});
            } else if (StringUtils.isBlank(transaction.getBenAcc())) {
                return this.getErrorUtils.getError("09", new String[]{"benAcc"});
            } else if (StringUtils.isBlank(transaction.getBankId())) {
                return this.getErrorUtils.getError("09", new String[]{"bankId"});
            } else {
                return StringUtils.isBlank(transaction.getTransContent()) ? this.getErrorUtils.getError("09", new String[]{"transContent"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
            }
        }
    }

    @KaiMethod(
            name = "getTransFastAcc"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        if ("970406".equals(transaction.getBankId()) && ("001".equals(transaction.getBenAcc()) || "002".equals(transaction.getBenAcc()))) {
            if (this.dbService.checkDup(transaction.getTransRef()) != null) {
                ApiError error = this.getErrorUtils.getError("11", new String[]{transaction.getBankId() + "#" + transaction.getBenAcc()});
                apiRes.setError(error);
                return apiRes;
            } else {
                String napasRef = this.dbService.insertTransaction(transaction);
                if (napasRef == null) {
                    ApiError error = this.getErrorUtils.getError("12");
                    apiRes.setError(error);
                    return apiRes;
                } else {
                    Map<String, Object> trs = new HashMap();
                    trs.put("napasRef", napasRef);
                    trs.put("responseCode", "00");
                    ApiBody apiBody = new ApiBody();
                    apiBody.put("transaction", trs);
                    apiRes.setBody(apiBody);
                    return apiRes;
                }
            }
        } else {
            ApiError error = this.getErrorUtils.getError("91", new String[]{transaction.getBankId() + "#" + transaction.getBenAcc()});
            apiRes.setError(error);
            return apiRes;
        }
    }
}
