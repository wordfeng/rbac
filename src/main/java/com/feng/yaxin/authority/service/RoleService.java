package com.feng.yaxin.authority.service;

import com.feng.yaxin.authority.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    /**
     * 新增角色
     */
    void insertRole(Role role);

    /**
     * 修改角色
     */
    void updateRole(Role role);

    /**
     * 删除角色
     */
    void deleteRoleByName(String roleName);


    /**
     * 查询角色
     * @param roleName 角色名
     * @return 角色实体
     */
    Role selectRoleByName(String roleName);

    /**
     * 分页查询角色
     * @return 角色实体列表
     */
    List<Role> selectAllRole(@Param("size") int size, @Param("pageNum") int pageNum);
}
