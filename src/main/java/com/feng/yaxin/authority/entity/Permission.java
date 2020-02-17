package com.feng.yaxin.authority.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = -9020301113131860187L;

    private Integer id;

    /**
     * 权限名
     */
    private String name;

    private LocalDateTime createTime;

    /**
     * 权限描述
     */
    private String description;

}
