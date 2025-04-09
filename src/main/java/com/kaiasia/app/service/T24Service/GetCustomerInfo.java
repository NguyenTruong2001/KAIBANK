package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.Enquiry;
import com.kaiasia.app.entity.Customer;
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
public class GetCustomerInfo extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetCustomerInfo() {
    }

    @KaiMethod(
            name = "KAI.API.CUST.GET.INFO",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        return StringUtils.isBlank(enquiry.getCustomerId()) ? this.getErrorUtils.getError("09", new String[]{"customerId"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
    }

    @KaiMethod(
            name = "KAI.API.CUST.GET.INFO"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        Customer customer = this.dbService.getCustomerById(enquiry.getCustomerId());
        if (customer == null) {
            ApiError apiError = this.getErrorUtils.getError("01", new String[]{enquiry.getCustomerId()});
            apiRes.setError(apiError);
            return apiRes;
        } else {
            ApiBody apiBody = new ApiBody();
            apiBody.put("enquiry", customer);
            apiRes.setBody(apiBody);
            return apiRes;
        }
    }
}
