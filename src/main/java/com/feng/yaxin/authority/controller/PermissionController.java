package com.feng.yaxin.authority.controller;


import com.feng.yaxin.authority.annotation.RestControllerMapping;
import com.feng.yaxin.authority.entity.Permission;
import com.feng.yaxin.authority.service.PermissionService;
import com.feng.yaxin.authority.utils.Responser;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerMapping("/api/permission")
public class PermissionController {

    @Resource
    PermissionService permissionService;

    /**
     * 创建权限
     */
    @PostMapping("/create")
    public Responser create(Permission permission) {
        permission.setCreateTime(LocalDateTime.now());
        permissionService.insertPermission(permission);
        return Responser.succeed();
    }

    /**
     * 删除权限
     * @param name 权限name
     */
    @DeleteMapping("/delete/name")
    public Responser delete(String name) {
        permissionService.deleteByName(name);
        return Responser.succeed();
    }

    /**
     * 删除权限
     * @param id 权限id
     */
    @DeleteMapping("/delete/id")
    public Responser deleteById(Integer id) {
        permissionService.deleteById(id);
        return Responser.succeed();
    }

    /**
     * 修改权限描述
     */
    @PostMapping("/modify")
    public Responser modify(Permission permission) {
        permissionService.updatePermission(permission);
        return Responser.succeed();
    }

    /**
     * 查询单个权限
     * @param id 权限id
     */
    @GetMapping("/query/id")
    public Responser queryById(Integer id) {
        Permission permission = permissionService.selectPermissionById(id);
        return Responser.succeed().putData(permission);
    }

    /**
     * 查询单个权限
     * @param name 权限name
     */
    @GetMapping("/query/name")
    public Responser queryByName(String name) {
        Permission permission = permissionService.selectPermissionByName(name);
        return Responser.succeed().putData(permission);
    }

    /**
     *
     * @param size 数据条数
     * @param pageNum 页数
     */
    @GetMapping("/query/{pageNum}/{size}")
    public Responser queryAll(@PathVariable Integer size, @PathVariable Integer pageNum) {
        List<Permission> list = permissionService.selectAllPermission(size, pageNum);
        return Responser.succeed().putData(list);
    }


}
