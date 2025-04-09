package com.kaiasia.app.repository;

import com.kaiasia.app.core.dao.CommonDAO;
import com.kaiasia.app.core.dao.PosgrestDAOHelper;
import com.kaiasia.app.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public class CustomerDAO extends CommonDAO implements ICustomerDAO {
    @Autowired
    private PosgrestDAOHelper posgrestDAOHelper;

    @Override
    public Customer getByCusId(final String cusId) throws Exception {
        StringBuilder sql = (new StringBuilder("SELECT * FROM ")).append(this.getTableName()).append(" WHERE id = :id ");
        Map<String, String> param = new HashMap();
        param.put("id", cusId);
        return (Customer)this.posgrestDAOHelper.querySingle(sql.toString(), param, new BeanPropertyRowMapper(Customer.class));
    }
}
