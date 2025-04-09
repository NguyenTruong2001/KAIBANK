package com.kaiasia.app.repository;

import com.kaiasia.app.entity.Ebank;

public interface IEbankDAO {
    Ebank getUserByUserName(String username) throws Exception;

    boolean updateFirstLogin(String username) throws Exception;

    boolean updatePassword(String password, String username) throws Exception;
}
