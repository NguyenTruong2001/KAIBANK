package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.Enquiry;
import com.kaiasia.app.dto.GetLoginResponse;
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

import java.util.Date;

@KaiService
public class GetLogin extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetLogin() {
    }

    @KaiMethod(
            name = "KAI.API.AUTHEN.GET.LOGIN",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        if (StringUtils.isBlank(enquiry.getUsername())) {
            return this.getErrorUtils.getError("09", new String[]{"username"});
        } else {
            return StringUtils.isBlank(enquiry.getPassword()) ? this.getErrorUtils.getError("09", new String[]{"password"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
        }
    }

    @KaiMethod(
            name = "KAI.API.AUTHEN.GET.LOGIN"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        Ebank ebank = this.dbService.getUserByUsername(enquiry.getUsername());
        ApiError apiError;
        if (ebank == null) {
            apiError = this.getErrorUtils.getError("05", new String[]{enquiry.getUsername()});
            apiRes.setError(apiError);
            return apiRes;
        } else if (!enquiry.getPassword().equals(ebank.getPassword())) {
            apiError = this.getErrorUtils.getError("04", new String[]{enquiry.getPassword()});
            apiRes.setError(apiError);
            return apiRes;
        } else if (ebank.getPasswordExpDate() != null && ebank.getPasswordExpDate().before(new Date())) {
            apiError = this.getErrorUtils.getError("03", new String[]{String.valueOf(ebank.getPasswordExpDate())});
            apiRes.setError(apiError);
            return apiRes;
        } else if (StringUtils.isNotBlank(ebank.getUserStatus()) && !"ACTIVE".equals(ebank.getUserStatus())) {
            apiError = this.getErrorUtils.getError("02", new String[]{ebank.getId()});
            apiRes.setError(apiError);
            return apiRes;
        } else {
            Customer customer = this.dbService.getCustomerById(ebank.getCifId());
            if (customer == null || StringUtils.isNotBlank(customer.getCifStatus()) && !"ACTIVE".equals(customer.getCifStatus())) {
                ApiError apiError1 = this.getErrorUtils.getError("05", new String[]{"CUSID#" + ebank.getCifId()});
                apiRes.setError(apiError1);
                return apiRes;
            } else {
                if (ebank.isFirstLogin()) {
                    this.dbService.updateFirstLogin(ebank.getId());
                }

                GetLoginResponse eqRes = new GetLoginResponse();
                eqRes.setUsername(ebank.getId());
                eqRes.setPackageUser(customer.getCustomerType());
                eqRes.setPhone(customer.getPhone());
                eqRes.setCustomerID(customer.getId());
                eqRes.setCustomerName(customer.getCifName());
                eqRes.setCompanyCode(ebank.getCoCode());
                eqRes.setFirstLogin(String.valueOf(ebank.isFirstLogin()));
                ApiBody apiBody = new ApiBody();
                apiBody.put("enquiry", eqRes);
                apiRes.setBody(apiBody);
                return apiRes;
            }
        }
    }
}
