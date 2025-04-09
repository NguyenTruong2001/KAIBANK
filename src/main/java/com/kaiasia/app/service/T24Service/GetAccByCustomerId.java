package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.AccountResponse;
import com.kaiasia.app.dto.Enquiry;
import com.kaiasia.app.entity.Account;
import com.kaiasia.app.entity.Customer;
import com.kaiasia.app.register.KaiMethod;
import com.kaiasia.app.register.KaiService;
import com.kaiasia.app.repository.CustomerDAO;
import com.kaiasia.app.repository.DBService;
import com.kaiasia.app.service.exception.ExceptionHandler;
import com.kaiasia.app.service.utils.ObjectAndJsonUtils;
import com.kaiasia.app.service.utils.ServiceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.apiclient.model.ApiBody;
import ms.apiclient.model.ApiError;
import ms.apiclient.model.ApiRequest;
import ms.apiclient.model.ApiResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

@KaiService
@Slf4j
@AllArgsConstructor
public class GetAccByCustomerId extends BaseService {
    private GetErrorUtils errorUtils;
    private ObjectMapper objectMapper;
    private DBService dbService;
    private ExceptionHandler exceptionHandler;

    @KaiMethod(
            name = "KAI.API.CUSTOMER.GET.ACC",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest apiRequest) {
        return ServiceUtils.validate(apiRequest, Enquiry.class, errorUtils, "ENQUIRY");
    }

    @KaiMethod(name = "KAI.API.CUSTOMER.GET.ACC")
//    public ApiResponse process(ApiRequest request) {
//        Enquiry enquiry = ObjectAndJsonUtils.fromObject(request
//                .getBody()
//                .get("enquiry"), Enquiry.class);
//        String location = "T24-getAccByCustomerId " + enquiry.getCustomerId() + "-" + System.currentTimeMillis();
//        return exceptionHandler.handle(request1 -> {
//            ApiResponse apiResponse = new ApiResponse();
//            Customer customer = null;
//            try {
//                customer = this.dbService.getCustomerById(enquiry.getCustomerId());
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//            if (customer != null && (!StringUtils.isNoneBlank(customer.getCifStatus()) || "ACTIVE".equals(customer.getCifStatus()))) {
//                List<AccountResponse> list = new ArrayList<>();
//                List<Account> accounts = null;
//                try {
//                    accounts = this.dbService.findAllByCustomerId(enquiry.getCustomerId());
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//                if (accounts != null && !accounts.isEmpty()) {
//                    Customer finalCustomer = customer;
//                    accounts.forEach((x) -> {
//                        list.add(new AccountResponse(x, finalCustomer));
//                    });
//                }
//                ApiBody apiBody = new ApiBody();
//                Map<String, Object> res = new HashMap<>();
//                res.put("accounts", list);
//                apiBody.put("enquiry", res);
//                apiResponse.setBody(apiBody);
//                return apiResponse;
//            } else {
//                ApiError apiError = this.errorUtils.getError("01", new String[]{enquiry.getCustomerId()});
//                apiResponse.setError(apiError);
//                return apiResponse;
//            }
//        }, request, location);
//    }
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        Customer customer = this.dbService.getCustomerById(enquiry.getCustomerId());
        if (customer != null && (!StringUtils.isNotBlank(customer.getCifStatus()) || "ACTIVE".equals(customer.getCifStatus()))) {
            List<AccountResponse> list = new ArrayList();
            List<Account> accounts = this.dbService.findAllByCustomerId(enquiry.getCustomerId());
            if (accounts != null && !accounts.isEmpty()) {
                accounts.forEach((x) -> {
                    list.add(new AccountResponse(x, customer));
                });
            }

            ApiBody apiBody = new ApiBody();
            Map<String, Object> res = new HashMap();
            res.put("accounts", list);
            apiBody.put("enquiry", res);
            apiRes.setBody(apiBody);
            return apiRes;
        } else {
            ApiError apiError = this.errorUtils.getError("01", new String[]{enquiry.getCustomerId()});
            apiRes.setError(apiError);
            return apiRes;
        }
    }
}

