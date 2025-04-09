package com.kaiasia.app.service.T24Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiasia.app.core.utils.GetErrorUtils;
import com.kaiasia.app.dto.Enquiry;
import com.kaiasia.app.dto.FTExistsResponse;
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
public class GetFTExist extends BaseService {
    @Autowired
    private GetErrorUtils getErrorUtils;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DBService dbService;

    public GetFTExist() {
    }

    @KaiMethod(
            name = "KAI.API.FT.EXISTS",
            type = "VALIDATE"
    )
    public ApiError validate(ApiRequest request) throws Exception {
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        return StringUtils.isBlank(enquiry.getTransactionId()) ? this.getErrorUtils.getError("09", new String[]{"transactionId"}) : new ApiError(ApiError.OK_CODE, ApiError.OK_DESC);
    }

    @KaiMethod(
            name = "KAI.API.FT.EXISTS"
    )
    public ApiResponse process(ApiRequest request) throws Exception {
        ApiResponse apiRes = new ApiResponse();
        Enquiry enquiry = (Enquiry)this.objectMapper.convertValue(this.getEnquiry(request), Enquiry.class);
        FundTransfer ftEd = this.dbService.getFtByTokenKey(enquiry.getTransactionId());
        FTExistsResponse res = null;
        if (ftEd == null) {
            res = new FTExistsResponse((String)null, "02");
        } else {
            res = new FTExistsResponse(ftEd.getId(), ftEd.getStatus());
        }

        ApiBody apiBody = new ApiBody();
        apiBody.put("enquiry", res);
        apiRes.setBody(apiBody);
        return apiRes;
    }
}

