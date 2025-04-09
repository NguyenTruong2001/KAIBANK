package com.kaiasia.app.repository;

import com.kaiasia.app.entity.BankCode;

import java.util.List;

public interface IBanksDAO {
    List<BankCode> select(String bankCode) throws Exception;
}
