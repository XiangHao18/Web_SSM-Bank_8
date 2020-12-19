package com.ssm.service;

import com.ssm.pojo.Customer;

public interface CustomerService {
    /**
     * 当Customer信息在数据库不存在，然后就注册Customer
     * @param customer
     * @return Customer
     * @throws Exception
     */
    public Customer inserCustomer(Customer customer) throws Exception;

    /**
     * 根据身份证号查找Customer是否存在，如果存在则返回他的信息
     * @param customer
     * @return Customer
     * @throws Exception
     */
    public Customer findCustomerByPid(Customer customer) throws Exception;

    /**
     * 根据custId更新修改Customer的信息
     * @param customer
     * @return Customer
     * @throws Exception
     */
    public Customer updateCustomer(Customer customer) throws Exception;

}
