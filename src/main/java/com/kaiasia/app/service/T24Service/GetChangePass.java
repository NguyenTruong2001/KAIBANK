package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.Transaction;
import com.kaiasia.app.entity.Ebank;
import com.kaiasia.app.register.KaiMethod;
import com.kaiasia.app.register.KaiService;
import com.kaiasia.app.repository.DBService;
import ms.apiclient.model.ApiBody;
import ms.apiclient.model.ApiError;
import ms.apiclient.model.ApiRequest;
import ms.apiclient.model.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@KaiService
public class GetChangePass extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetChangePass() {
    }

    @KaiMethod(
            name = "KAI.API.USER.CHANGEPASS",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        if (StringUtils.isBlank(transaction.getUsername())) {
            return this.getErrorUtils.getError("09", new String[]{"username"});
        } else {
            return StringUtils.isBlank(transaction.getNewPassword()) ? this.getErrorUtils.getError("09", new String[]{"newPassword"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
        }
    }

    @KaiMethod(
            name = "KAI.API.USER.CHANGEPASS"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Transaction transaction = (Transaction)this.objectMapper.convertValue(this.getTransaction(request), Transaction.class);
        Ebank ebank = this.dbService.getUserByUsername(transaction.getUsername());
        if (ebank == null) {
            ApiError apiError = this.getErrorUtils.getError("05", new String[]{transaction.getUsername()});
            apiRes.setError(apiError);
            return apiRes;
        } else {
            boolean changePass = this.dbService.updatePassword(transaction.getNewPassword(), transaction.getUsername());
            if (!changePass) {
                ApiError apiError = this.getErrorUtils.getError("999", new String[]{"Loi doi mat khau#" + transaction.getUsername()});
                apiRes.setError(apiError);
                return apiRes;
            } else {
                Map<String, Object> trs = new HashMap();
                trs.put("username", transaction.getUsername());
                trs.put("responseCode", "00");
                ApiBody apiBody = new ApiBody();
                apiBody.put("transaction", trs);
                apiRes.setBody(apiBody);
                return apiRes;
            }
        }
    }
}
