package com.ssm.service.impl;

import com.ssm.mapper.CustomerMapper;
import com.ssm.pojo.Customer;
import com.ssm.pojo.CustomerExample;
import com.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer inserCustomer(Customer customer) throws Exception {
        if (findCustomerByPid(customer)==null){
            return customerMapper.insert(customer) > 0 ? customer : null;
        }
        return null;
    }

    @Override
    public Customer findCustomerByPid(Customer customer) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andCustPidEqualTo(customer.getCustPid());
        List<Customer> list = customerMapper.selectByExample(customerExample);
        for (Customer customers : list){
            if (customers.getCustPid().equals(customer.getCustPid()))
                return customers;
        }
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws Exception {
        return customerMapper.updateByPrimaryKey(customer) > 0 ? customer : null;
    }
}
