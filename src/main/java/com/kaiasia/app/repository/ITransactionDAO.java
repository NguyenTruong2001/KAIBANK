package com.kaiasia.app.repository;


import com.kaiasia.app.entity.NapasTransaction;

public interface ITransactionDAO {
    NapasTransaction getByRef(String ft) throws Exception;

    int insert(NapasTransaction napasTransaction) throws Exception;
}
