package com.ssm.service.impl;

import com.ssm.mapper.TransactionMapper;
import com.ssm.pojo.Transaction;
import com.ssm.pojo.TransactionExample;
import com.ssm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public Transaction insertTransaction(Transaction transaction) throws Exception {
        return transactionMapper.insert(transaction) > 0 ? transaction : null;
    }

    @Override
    public List<Transaction> findTransactionAll(String cardId) throws Exception {
        TransactionExample transactionExample = new TransactionExample();
        TransactionExample.Criteria criteria = transactionExample.createCriteria();
        criteria.andCardIdEqualTo(cardId);
        return transactionMapper.selectByExample(transactionExample);
    }
}
