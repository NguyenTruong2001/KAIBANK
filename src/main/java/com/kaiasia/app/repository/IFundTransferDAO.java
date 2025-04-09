package com.kaiasia.app.repository;

import com.kaiasia.app.entity.FundTransfer;

public interface IFundTransferDAO {
    FundTransfer getByTokenKey(String ft) throws Exception;

    int insert(FundTransfer fundTransfer) throws Exception;

    boolean updateReverted(String id) throws Exception;
}
