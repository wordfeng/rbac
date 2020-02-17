package com.feng.yaxin.authority.ao;


import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class CreateAccountAo {
    @Pattern(regexp = "[\\w+]{5,16}", message = "账号或密码格式错误！")
    String account;
    @Pattern(regexp = "[\\w+]{5,16}", message = "账号或密码格式错误！")
    String password;
    @Pattern(regexp = "[\\u4e00-\\u9fa5]{2,10}")
    String name;
}
