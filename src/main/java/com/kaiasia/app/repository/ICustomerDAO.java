package com.kaiasia.app.repository;

import com.kaiasia.app.entity.Customer;

public interface ICustomerDAO {
    Customer getByCusId(String cusId) throws Exception;
}
