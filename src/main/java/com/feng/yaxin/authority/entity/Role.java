package com.feng.yaxin.authority.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -487610102642110422L;
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    private LocalDateTime createTime;

    /**
     * 角色描述
     */
    private String description;

}
