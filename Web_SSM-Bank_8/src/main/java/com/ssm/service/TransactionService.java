package com.ssm.service;

import com.ssm.pojo.Transaction;

import java.util.List;

public interface TransactionService {
    /**
     * 添加交易记录
     * @param transaction
     * @return Transaction
     * @throws Exception
     */
    public Transaction insertTransaction(Transaction transaction) throws Exception;

    /**
     * 查询cardId的所有交易记录
     * @param cardId
     * @return List<Transaction>
     * @throws Exception
     */
    public List<Transaction> findTransactionAll(String cardId) throws Exception;
}
