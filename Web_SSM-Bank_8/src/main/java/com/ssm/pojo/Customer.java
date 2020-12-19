package com.ssm.pojo;

import com.ssm.controller.validation.ValidGroupByCustomer;

import javax.validation.constraints.Size;

public class Customer extends CustomerKey {
    @Size(min = 4,max = 20,message = "customer.name.length.error",groups = ValidGroupByCustomer.class)
    private String custName;

    @Size(min = 11,max = 11,message = "customer.tel.length.error",groups = ValidGroupByCustomer.class)
    private String custTel;

    @Size(min = 1,max = 255,message = "customer.address.length.error",groups = ValidGroupByCustomer.class)
    private String custAddress;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel == null ? null : custTel.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }
}