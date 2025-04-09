package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.FTExistsResponse;
import com.kaiasia.app.dto.Transaction;
import com.kaiasia.app.entity.FundTransfer;
import com.kaiasia.app.register.KaiMethod;
import com.kaiasia.app.register.KaiService;
import com.kaiasia.app.repository.DBService;
import ms.apiclient.model.ApiBody;
import ms.apiclient.model.ApiError;
import ms.apiclient.model.ApiRequest;
import ms.apiclient.model.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@KaiService
public class GetRevertFT extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetRevertFT() {
    }

    @KaiMethod(
            name = "KAI.API.REVERT.FT",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        return StringUtils.isBlank(transaction.getTransactionId()) ? this.getErrorUtils.getError("09", new String[]{"transactionId"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
    }

    @KaiMethod(
            name = "KAI.API.REVERT.FT"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        FundTransfer ftEd = this.dbService.getFtByTokenKey(transaction.getTransactionId());
        FTExistsResponse res = null;
        ApiError apiError;
        if (ftEd == null) {
            apiError = this.getErrorUtils.getError("12", new String[]{transaction.getTransactionId()});
            apiRes.setError(apiError);
            return apiRes;
        } else if ("01".equals(ftEd.getStatus())) {
            apiError = this.getErrorUtils.getError("13", new String[]{transaction.getTransactionId()});
            apiRes.setError(apiError);
            return apiRes;
        } else if (this.dbService.updateReverted(ftEd.getId())) {
            res = new FTExistsResponse(ftEd.getId(), "00");
            ApiBody apiBody = new ApiBody();
            apiBody.put("transaction", res);
            apiRes.setBody(apiBody);
            return apiRes;
        } else {
            apiError = this.getErrorUtils.getError("999", new String[]{transaction.getTransactionId()});
            apiRes.setError(apiError);
            return apiRes;
        }
    }
}
