package com.ssm.pojo;


import com.ssm.controller.validation.ValidGroupByCustomer;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;

public class CustomerKey {
    private Integer custId;

    @Size(min = 18,max = 18,message = "customer.pid.length.error",groups = ValidGroupByCustomer.class)
    private String custPid;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustPid() {
        return custPid;
    }

    public void setCustPid(String custPid) {
        this.custPid = custPid == null ? null : custPid.trim();
    }
}