package com.feng.yaxin.authority.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RelRolePermission implements Serializable {

    private static final long serialVersionUID = 7620646991645648504L;

    private Integer roleId;

    private Integer permissionId;

}
