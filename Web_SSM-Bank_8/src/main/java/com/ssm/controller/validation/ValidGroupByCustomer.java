package com.ssm.controller.validation;

public interface ValidGroupByCustomer {
    //接口中不需要定义任何方法，仅是对不同的校验规则进行分组

    //姓名低于4位字符或超过20位字符
    //身份证号不能低于18位字符
    //电话号不能少于11位
    //家庭地址不能大于255位字符
}
