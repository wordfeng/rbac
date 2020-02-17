package com.feng.yaxin.authority.controller;

import com.feng.yaxin.authority.annotation.RestControllerMapping;
import com.feng.yaxin.authority.entity.Permission;
import com.feng.yaxin.authority.entity.RelRolePermission;
import com.feng.yaxin.authority.service.RelRolePermissionService;
import com.feng.yaxin.authority.utils.Responser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerMapping("/api/role/permission")
public class RelRolePermissionController {

    @Resource
    RelRolePermissionService service;

    /**
     * 给角色添加权限
     *
     * @param roleId       角色id
     * @param permissionId 权限id
     */
    @PostMapping("/add")
    public Responser add(Integer roleId, Integer permissionId) {
        service.addPermission(roleId, permissionId);
        return Responser.succeed();
    }

    /**
     * 删除角色对应的权限
     *
     * @param roleId       角色id
     * @param permissionId 权限id
     */
    @DeleteMapping("/delete")
    public Responser delete(Integer roleId, Integer permissionId) {
        service.deletePermission(roleId, permissionId);
        return Responser.succeed();
    }

    /**
     * 修改账户对应的角色
     *
     * @param roleId          角色id
     * @param permissionId    权限id
     * @param newPermissionId 新权限id
     */
    @PostMapping("/update")
    public Responser update(Integer roleId, Integer permissionId, Integer newPermissionId) {
        service.update(roleId, permissionId, newPermissionId);
        return Responser.succeed();
    }

    /**
     * 查询角色拥有的权限
     *
     * @param roleId 角色id
     */
    @GetMapping("/query/id/{roleId}")
    public Responser query(@PathVariable Integer roleId) {
        List<Permission> list = service.selectPermissionById(roleId);
        return Responser.succeed().putData(list);
    }

    /**
     * 查询角色拥有的权限
     *
     * @param roleName 角色name
     */
    @GetMapping("/query/name/{roleName}")
    public Responser query(@PathVariable String roleName) {
        List<Permission> list = service.selectPermissionByName(roleName);
        return Responser.succeed().putData(list);
    }
}
