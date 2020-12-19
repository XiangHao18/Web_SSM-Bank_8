package com.ssm.service;

import com.ssm.pojo.Bankcard;

import java.util.List;

public interface BankcardService {
    /**
     * 当Bankcard信息在数据库不存在，然后就添加Bankcard
     * @param bankcard
     * @return Bankcard
     * @throws Exception
     */
    public Bankcard insertBankCard(Bankcard bankcard) throws Exception;

    /**
     * 根据银行卡号查询Bankcard是否存在，如果存在则返回他的信息
     * @param bankcard
     * @return Bankcard
     * @throws Exception
     */
    public Bankcard findBankCardByCardId(Bankcard bankcard) throws Exception;

    /**
     * 根据银行卡号更新Bankcard的余额
     * @param bankcard
     * @return Bankcard
     * @throws Exception
     */
    public Bankcard updateBankCard(Bankcard bankcard) throws Exception;

    /**
     * 根据银行卡号删除Bankcard的信息
     * @param bankcard
     * @return Bankcard
     * @throws Exception
     */
    public Bankcard deleteBankCard(Bankcard bankcard) throws Exception;

    /**
     * 根据客户编号查询客户的所有Bankcrad的信息
     * @param bankcard
     * @return List<Bankcard>
     * @throws Exception
     */
    public List<Bankcard> findBankCardAll(Bankcard bankcard) throws Exception;

    /**
     *  卡号cardId转账给卡号TcarId，金额为Tmoney
     * @param cardId
     * @param Tmoney
     * @param TcarId
     * @return
     * @throws Exception
     */
    public boolean Transfer(String cardId,Double Tmoney,String TcarId) throws Exception;

    /**
     * 随机生成银行卡号
     * @return 银行卡号
     * @throws Exception
     */
    public String getCardId() throws Exception;
}
