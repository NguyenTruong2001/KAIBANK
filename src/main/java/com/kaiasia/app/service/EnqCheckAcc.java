package com.kaiasia.app.service;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.AccountResponse;
import com.kaiasia.app.dto.Enquiry;
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
public class EnqCheckAcc extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public EnqCheckAcc() {
    }

    @KaiMethod(
            name = "enqCheckAcc",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        if (StringUtils.isBlank(enquiry.getSenderAccount())) {
            return this.getErrorUtils.getError("09", new String[]{"senderAccount"});
        } else if (StringUtils.isBlank(enquiry.getSenderName())) {
            return this.getErrorUtils.getError("09", new String[]{"senderName"});
        } else if (StringUtils.isBlank(enquiry.getAccountId())) {
            return this.getErrorUtils.getError("09", new String[]{"accountId"});
        } else {
            return StringUtils.isBlank(enquiry.getBankId()) ? this.getErrorUtils.getError("09", new String[]{"bankId"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
        }
    }

    @KaiMethod(
            name = "enqCheckAcc"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        if ("970406".equals(enquiry.getBankId()) && ("001".equals(enquiry.getAccountId()) || "002".equals(enquiry.getAccountId()) || "003".equals(enquiry.getAccountId()))) {
            AccountResponse accountResponse = this.getAccountResponse(enquiry.getBankId(), enquiry.getAccountId());
            ApiBody apiBody = new ApiBody();
            Map<String, Object> res = new HashMap();
            res.put("responseCode", "00");
            res.put("accountInfo", accountResponse);
            apiBody.put("enquiry", res);
            apiRes.setBody(apiBody);
            return apiRes;
        } else {
            ApiError error = this.getErrorUtils.getError("91", new String[]{enquiry.getBankId() + "#" + enquiry.getAccountId()});
            apiRes.setError(error);
            return apiRes;
        }
    }

    private AccountResponse getAccountResponse(String bankId, String accountId) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setBankId(bankId);
        if ("001".equals(accountId)) {
            accountResponse.setAccountId(accountId);
            accountResponse.setAccountName("NGUYEN VAN A");
        } else if ("002".equals(accountId)) {
            accountResponse.setAccountId(accountId);
            accountResponse.setAccountName("NGUYEN VAN B");
        } else if ("003".equals(accountId)) {
            accountResponse.setAccountId(accountId);
            accountResponse.setAccountName("NGUYEN VAN C");
        }

        return accountResponse;
    }
}
