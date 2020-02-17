package com.feng.yaxin.authority.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Account implements Serializable {

    private static final long serialVersionUID = -24081734800253135L;

    private Integer id;

    /**
     * 账号
     */
    private String account;
    /**
     * 名字
     */
    private String name;
    private String password;

    /**
     * 是否已删除
     */
    private Boolean deleted;

    private LocalDateTime createTime;

    private LocalDateTime lastModifiedTime;

    private Integer createUserId;
}
