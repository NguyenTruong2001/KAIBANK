package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.BankResponse;
import com.kaiasia.app.dto.Enquiry;
import com.kaiasia.app.entity.BankCode;
import com.kaiasia.app.register.KaiMethod;
import com.kaiasia.app.register.KaiService;
import com.kaiasia.app.repository.DBService;
import ms.apiclient.model.ApiBody;
import ms.apiclient.model.ApiError;
import ms.apiclient.model.ApiRequest;
import ms.apiclient.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@KaiService
public class GetBanks extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetBanks() {
    }

    @KaiMethod(
            name = "KAI.API.BANKS",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        return new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
    }

    @KaiMethod(
            name = "KAI.API.BANKS"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        List<BankCode> banks = this.dbService.getBanks(enquiry.getBankCode());
        List<BankResponse> list = new ArrayList();
        if (banks != null || !banks.isEmpty()) {
            Iterator var6 = banks.iterator();

            while(var6.hasNext()) {
                BankCode b = (BankCode)var6.next();
                list.add(new BankResponse(b.getBankCode(), b.getBankName(), b.isStatus(), b.getNapasId()));
            }
        }

        ApiBody apiBody = new ApiBody();
        Map<String, Object> bankss = new HashMap();
        bankss.put("banks", list);
        apiBody.put("enquiry", bankss);
        apiRes.setBody(apiBody);
        return apiRes;
    }
}
