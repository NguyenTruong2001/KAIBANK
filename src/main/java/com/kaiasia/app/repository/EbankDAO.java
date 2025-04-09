package com.kaiasia.app.repository;

import com.kaiasia.app.core.dao.CommonDAO;
import com.kaiasia.app.core.dao.PosgrestDAOHelper;
import com.kaiasia.app.entity.Ebank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.HashMap;
import java.util.Map;

public class EbankDAO extends CommonDAO implements IEbankDAO {
    @Autowired
    private PosgrestDAOHelper posgrestDAOHelper;

    public EbankDAO() {
    }

    public Ebank getUserByUserName(String username) throws Exception {
        StringBuffer sql = (new StringBuffer("SELECT * FROM ")).append(this.getTableName()).append(" WHERE id = :username ");
        Map<String, String> param = new HashMap();
        param.put("username", username);
        return (Ebank)this.posgrestDAOHelper.querySingle(sql.toString(), param, new BeanPropertyRowMapper(Ebank.class));
    }

    public boolean updateFirstLogin(String username) throws Exception {
        StringBuffer sql = (new StringBuffer("UPDATE ")).append(this.getTableName()).append(" set is_first_login = false WHERE id = :username ");
        Map<String, String> param = new HashMap();
        param.put("username", username);
        return this.posgrestDAOHelper.update(sql.toString(), param) > 0;
    }

    public boolean updatePassword(String password, String username) throws Exception {
        StringBuffer sql = (new StringBuffer("UPDATE ")).append(this.getTableName()).append(" set password = :password WHERE id = :username ");
        Map<String, String> param = new HashMap();
        param.put("username", username);
        param.put("password", password);
        return this.posgrestDAOHelper.update(sql.toString(), param) > 0;
    }
}

