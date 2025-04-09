package com.kaiasia.app.repository;

import com.kaiasia.app.core.dao.CommonDAO;
import com.kaiasia.app.core.dao.PosgrestDAOHelper;
import com.kaiasia.app.entity.BankCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BanksDAO extends CommonDAO implements IBanksDAO {
    @Autowired
    private PosgrestDAOHelper posgrestDAOHelper;

    public BanksDAO() {
    }

    public List<BankCode> select(String bankCode) throws Exception {
        StringBuilder sql = (new StringBuilder("SELECT * FROM ")).append(this.getTableName()).append(" WHERE 1 = 1 ");
        Map<String, Object> param = new HashMap();
        if (StringUtils.isNotBlank(bankCode)) {
            sql.append(" AND bank_code = :bankCode ");
            param.put("bankCode", bankCode);
        }

        return this.posgrestDAOHelper.query(sql.toString(), param, new BeanPropertyRowMapper(BankCode.class));
    }
}
