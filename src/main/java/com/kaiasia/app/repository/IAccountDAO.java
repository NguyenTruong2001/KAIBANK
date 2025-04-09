package com.kaiasia.app.repository;

import com.kaiasia.app.entity.Account;

import java.util.List;

public interface IAccountDAO {
    List<Account> findAllByCustomerId(String cusId) throws Exception;
    Account getAccountInfo(String accId) throws Exception;

    Account getAccountForUpdate(String accId) throws Exception;

    int update(Account account) throws Exception;
}
