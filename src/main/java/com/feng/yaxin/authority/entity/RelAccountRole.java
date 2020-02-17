package com.feng.yaxin.authority.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RelAccountRole implements Serializable {

    private static final long serialVersionUID = 6380870001116479098L;

    /**
     * 账户id
     */
    private Integer accountId;

    /**
     * 角色id
     */
    private Integer roleId;

}
