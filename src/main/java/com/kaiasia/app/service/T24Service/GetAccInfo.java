package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.AccountResponse;
import com.kaiasia.app.dto.Enquiry;
import com.kaiasia.app.entity.Account;
import com.kaiasia.app.entity.Customer;
import com.kaiasia.app.register.KaiMethod;
import com.kaiasia.app.register.KaiService;
import com.kaiasia.app.register.Register;
import com.kaiasia.app.repository.DBService;
import com.kaiasia.app.service.exception.ExceptionHandler;
import com.kaiasia.app.service.utils.ObjectAndJsonUtils;
import com.kaiasia.app.service.utils.ServiceUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.apiclient.model.ApiBody;
import ms.apiclient.model.ApiError;
import ms.apiclient.model.ApiRequest;
import ms.apiclient.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

@KaiService
@Slf4j
@RequiredArgsConstructor
public class GetAccInfo extends BaseService {
    private final GetErrorUtils getErrorUtils;
    private final ObjectMapper objectMapper;
    private final DBService dbService;
    private final ExceptionHandler exceptionHandler;

    @KaiMethod(
            name = "KAI.API.ACCOUNT.GET.INFO",
            type = Register.VALIDATE
    )
    public ApiError validate(ApiRequest req) {
        return ServiceUtils.validate(req, AccountResponse.class, getErrorUtils, "ENQUIRY");
    }

    @KaiMethod(
            name = "KAI.API.ACCOUNT.GET.INFO"
    )
//    public ApiResponse process(ApiRequest request) throws Exception {
//        ApiResponse apiRes = new ApiResponse();
//        Enquiry enquiry = (Enquiry) this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
//        Account account = this.dbService.getAccountInfo(enquiry.getAccountId());
//        if (account == null) {
//            ApiError apiError = this.getErrorUtils.getError("06", new String[]{enquiry.getAccountId()});
//            apiRes.setError(apiError);
//            return apiRes;
//        } else {
//            Customer customer = this.dbService.getCustomerById(account.getCifId());
//            if (customer == null) {
//                ApiError apiError = this.getErrorUtils.getError("01", new String[]{account.getCifId()});
//                apiRes.setError(apiError);
//                return apiRes;
//            } else {
//                AccountResponse accountResponse = new AccountResponse(account, customer, account.getBalance());
//                ApiBody apiBody = new ApiBody();
//                apiBody.put("enquiry", accountResponse);
//                apiRes.setBody(apiBody);
//                return apiRes;
//            }
//        }
//    }

    public ApiResponse process(ApiRequest request) throws Exception {
        Enquiry enquiryRq = ObjectAndJsonUtils.fromObject(request
                .getBody()
                .get("enquiry"), Enquiry.class);
        String location = "T24-AccountGetInfo " + enquiryRq.getAccountId() + "-" + System.currentTimeMillis();
        return exceptionHandler.handle(request1 -> {
            ApiResponse apiRes = new ApiResponse();
            Account account = null;
            try {
                account = this.dbService.getAccountInfo(enquiryRq.getAccountId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (account == null) {
                ApiError apiError = this.getErrorUtils.getError("06", new String[]{enquiryRq.getAccountId()});
                apiRes.setError(apiError);
                return apiRes;
            } else {
                Customer customer = null;
                try {
                    customer = this.dbService.getCustomerById(account.getCifId());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (customer == null) {
                    ApiError apiError = this.getErrorUtils.getError("01", new String[]{account.getCifId()});
                    apiRes.setError(apiError);
                    return apiRes;
                } else {
                    AccountResponse accountResponse = new AccountResponse(account, customer, account.getBalance());
                    ApiBody apiBody = new ApiBody();
                    apiBody.put("enquiry", accountResponse);
                    apiRes.setBody(apiBody);
                    return apiRes;
                }
            }
            },request,location);
    }
}
