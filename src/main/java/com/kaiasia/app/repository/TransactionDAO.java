package com.kaiasia.app.repository;

import com.kaiasia.app.core.dao.CommonDAO;
import com.kaiasia.app.core.dao.PosgrestDAOHelper;
import com.kaiasia.app.entity.NapasTransaction;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class TransactionDAO extends CommonDAO implements ITransactionDAO {
    @Autowired
    private PosgrestDAOHelper posgrestDAOHelper;

    public TransactionDAO() {
    }

    public NapasTransaction getByRef(String transactionId) throws Exception {
        StringBuilder sql = (new StringBuilder("SELECT * FROM ")).append(this.getTableName()).append(" WHERE trans_ref = :trans_ref ");
        Map<String, Object> param = new HashMap();
        param.put("trans_ref", transactionId);
        return (NapasTransaction)this.posgrestDAOHelper.querySingle(sql.toString(), param, new BeanPropertyRowMapper(NapasTransaction.class));
    }

    public int insert(NapasTransaction napasTransaction) throws Exception {
        StringBuilder sql = (new StringBuilder("INSERT INTO ")).append(this.getTableName()).append(" (").append("sender_account, amount, ccy, trans_ref, ben_acc, bank_id, trans_content, napas_ref, time_update)").append(" values (:sender_account, :amount, :ccy, :trans_ref, :ben_acc, :bank_id, :trans_content, :napas_ref, :time_update) ");
        Map<String, Object> param = new HashMap();
        param.put("sender_account", napasTransaction.getSenderAccount());
        param.put("amount", napasTransaction.getAmount());
        param.put("ccy", napasTransaction.getCcy());
        param.put("trans_ref", napasTransaction.getTransRef());
        param.put("ben_acc", napasTransaction.getBenAcc());
        param.put("bank_id", napasTransaction.getBankId());
        param.put("trans_content", napasTransaction.getTransContent());
        param.put("napas_ref", napasTransaction.getNapasRef());
        param.put("time_update", LocalDateTime.now());
        return this.posgrestDAOHelper.update(sql.toString(), param);
    }
}
