package com.kaiasia.app.repository;

import com.kaiasia.app.core.dao.CommonDAO;
import com.kaiasia.app.core.dao.PosgrestDAOHelper;
import com.kaiasia.app.entity.Account;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AccountDAO extends CommonDAO implements IAccountDAO {

    @Autowired
    private PosgrestDAOHelper posgrestDAOHelper;

    public AccountDAO() {
    }


    @Override
    public List<Account> findAllByCustomerId(final String cusId) throws Exception {
        StringBuilder sql = (new StringBuilder("SELECT * FROM ")).append(this.getTableName()).append(" WHERE cif_id = :cusId ");
        Map<String, Object> param = new HashMap();
        param.put("cusId", cusId);
        return this.posgrestDAOHelper.query(sql.toString(), param, new BeanPropertyRowMapper(Account.class));
    }

    @Override
    public Account getAccountInfo(final String accId) throws Exception {
        StringBuilder sql = (new StringBuilder("SELECT * FROM ")).append(this.getTableName()).append(" WHERE acc_id = :accId");
        Map<String, Object> param = new HashMap<>();
        param.put("accId", accId);
        return (Account) this.posgrestDAOHelper.querySingle(sql.toString(), param, new BeanPropertyRowMapper(Account.class));
    }

    @Override
    public Account getAccountForUpdate(final String accId) throws Exception {
        StringBuilder sql = (new StringBuilder("SELECT * FROM ")).append(this.getTableName()).append(" WHERE ac_cid = :accId for update");
        Map<String, Object> param = new HashMap();
        param.put("accId", accId);
        return (Account) this.posgrestDAOHelper.querySingle(sql.toString(), param, new BeanPropertyRowMapper(Account.class));
    }

    @Override
    public int update(final Account account) throws Exception {
        StringBuilder sql = (new StringBuilder("UPDATE ")).append(this.getTableName()).append(" SET acc_id = :acc_id,");
        Map<String, Object> param = new HashMap();
        if (StringUtils.isNotBlank(account.getAltAcc())) {
            sql.append("alt_acc = :alt_acc,");
            param.put("alt_acc", account.getAltAcc());
        }

        if (StringUtils.isNotBlank(account.getCifId())) {
            sql.append("cif_id = :cif_id,");
            param.put("cif_id", account.getCifId());
        }

        if (StringUtils.isNotBlank(account.getCategory())) {
            sql.append("category = :category,");
            param.put("category", account.getCategory());
        }

        if (StringUtils.isNotBlank(account.getAltAcc())) {
            sql.append("account_title = :account_title,");
            param.put("account_title", account.getAccountTitle());
        }

        if (StringUtils.isNotBlank(account.getCcy())) {
            sql.append("ccy = :ccy,");
            param.put("ccy", account.getCcy());
        }

        if (StringUtils.isNotBlank(account.getCoCode())) {
            sql.append("co_code = :co_code,");
            param.put("co_code", account.getCoCode());
        }

        if (Objects.nonNull(account.getBalance())) {
            sql.append("balance = :balance,");
            param.put("balance", account.getBalance());
        }

        if (StringUtils.isNotBlank(account.getAccountStatus())) {
            sql.append("account_status = :account_status,");
            param.put("account_status", account.getAccountStatus());
        }

        if (StringUtils.isNotBlank(account.getProductCode())) {
            sql.append("product_code = :product_code,");
            param.put("product_code", account.getProductCode());
        }

        String sqlD = sql.substring(0, sql.length() - 1);
        sqlD = sqlD.concat(" WHERE acc_id = :acc_id ");
        param.put("acc_id", account.getAccId());
        return this.posgrestDAOHelper.update(sqlD, param);
    }
}
