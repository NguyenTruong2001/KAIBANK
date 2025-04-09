package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.EbankUserResponse;
import com.kaiasia.app.dto.Enquiry;
import com.kaiasia.app.entity.Account;
import com.kaiasia.app.entity.Customer;
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

@KaiService
public class GetUserInfo extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetUserInfo() {
    }

    @KaiMethod(
            name = "KAI.API.USER.GET.INFO",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        return StringUtils.isBlank(enquiry.getUsername()) ? this.getErrorUtils.getError("09", new String[]{"username"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
    }

    @KaiMethod(
            name = "KAI.API.USER.GET.INFO"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        Ebank ebank = this.dbService.getUserByUsername(enquiry.getUsername());
        if (ebank == null) {
            ApiError apiError = this.getErrorUtils.getError("05", new String[]{enquiry.getUsername()});
            apiRes.setError(apiError);
            return apiRes;
        } else {
            Customer customer = this.dbService.getCustomerById(ebank.getCifId());
            if (customer == null) {
                ApiError apiError = this.getErrorUtils.getError("01", new String[]{ebank.getCifId()});
                apiRes.setError(apiError);
                return apiRes;
            } else {
                Account account = this.dbService.getAccountInfo(ebank.getMainAcc());
                if (account == null) {
                    ApiError apiError = this.getErrorUtils.getError("06", new String[]{enquiry.getAccountId()});
                    apiRes.setError(apiError);
                    return apiRes;
                } else {
                    EbankUserResponse res = new EbankUserResponse(ebank, customer);
                    ApiBody apiBody = new ApiBody();
                    apiBody.put("enquiry", res);
                    apiRes.setBody(apiBody);
                    return apiRes;
                }
            }
        }
    }
}
