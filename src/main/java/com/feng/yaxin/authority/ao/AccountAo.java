package com.feng.yaxin.authority.ao;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AccountAo {

    @Pattern(regexp = "[\\w+]{5,16}", message = "账号或密码错误！")
    String account;
    @Pattern(regexp = "[\\w+]{5,16}", message = "账号或密码错误！")
    String password;

}
