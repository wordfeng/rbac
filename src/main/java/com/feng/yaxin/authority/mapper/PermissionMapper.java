package com.feng.yaxin.authority.mapper;

import com.feng.yaxin.authority.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {


    /**
     * 添加权限
     *
     * @param permission 权限实体
     */
    void insertPermission(Permission permission);

    /**
     * 删除权限
     *
     * @param id 权限id
     */
    void deleteById(Integer id);

    /**
     * 删除权限
     *
     * @param name 权限name
     */
    void deleteByName(String name);

    /**
     * 修改权限
     *
     * @param permission 权限实体
     */
    void updatePermission(Permission permission);

    /**
     * 查询权限
     *
     * @param permissionName 权限名
     * @return 权限实体
     */
    Permission selectPermissionByName(String permissionName);

    /**
     * 查询权限
     *
     * @param permissionId 权限id
     * @return 权限实体
     */
    Permission selectPermissionById(Integer permissionId);


    /**
     * 查询所有权限
     *
     * @return 权限实体列表
     */
    List<Permission> selectAllPermission(@Param("size") int size, @Param("pageNum") int pageNum);
}
