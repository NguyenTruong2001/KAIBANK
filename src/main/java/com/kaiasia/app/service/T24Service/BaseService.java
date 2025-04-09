package com.kaiasia.app.service.T24Service;

import ms.apiclient.model.ApiRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BaseService {
    public BaseService() {
    }

    public Map<String, Object> getEnquiry(ApiRequest request) {
        return (Map) request.getBody().get("enquiry");
    }

    public Map<String, Object> getTransaction(ApiRequest request) {
        return (Map) request.getBody().get("transaction");
    }
}

