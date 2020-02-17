package com.feng.yaxin.authority.service;

import com.feng.yaxin.authority.entity.Permission;

import java.util.List;

public interface RelRolePermissionService {

    /**
     * 给角色添加权限
     *
     * @param roleId       角色id
     * @param permissionId 权限id
     */
    void addPermission(Integer roleId, Integer permissionId);

    /**
     * 删除账户的角色
     *
     * @param roleId       角色id
     * @param permissionId 权限id
     */
    void deletePermission(Integer roleId, Integer permissionId);

    /**
     * 修改账户对应的角色
     *
     * @param roleId          角色id
     * @param permissionId    权限id
     * @param newPermissionId 新权限id
     */
    void update(Integer roleId, Integer permissionId, Integer newPermissionId);

    /**
     * 查询角色拥有的权限
     *
     * @param roleName 角色名
     */
    List<Permission> selectPermissionByName(String roleName);

    /**
     * 查询角色拥有的权限
     *
     * @param roleId 角色id
     */
    List<Permission> selectPermissionById(Integer roleId);

}
