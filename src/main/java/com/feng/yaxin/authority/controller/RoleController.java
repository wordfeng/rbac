package com.feng.yaxin.authority.controller;

import com.feng.yaxin.authority.annotation.RestControllerMapping;
import com.feng.yaxin.authority.entity.Role;
import com.feng.yaxin.authority.mapper.RoleMapper;
import com.feng.yaxin.authority.utils.Responser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerMapping("/api/role")
public class RoleController {

    @Resource
    RoleMapper mapper;

    /**
     * 创建角色
     */
    @PostMapping("/create")
    public Responser create(Role role) {
        role.setCreateTime(LocalDateTime.now());
        mapper.insertRole(role);
        return Responser.succeed();
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/delete")
    public Responser delete(String name) {
        mapper.deleteRoleByName(name);
        return Responser.succeed();
    }

    /**
     * 修改角色
     */
    @PostMapping("/modify")
    public Responser modify(Role role) {
        mapper.updateRole(role);
        return Responser.succeed();
    }

    /**
     * 查询单个角色
     */
    @GetMapping("/query/{name}")
    public Responser query(@PathVariable String name) {
        Role role = mapper.selectRoleByName(name);
        return Responser.succeed().putData(role);
    }

    /**
     * 分页查询角色
     */
    @GetMapping("/query/{pageNum}/{size}")
    public Responser queryAll(@PathVariable Integer size, @PathVariable Integer pageNum) {
        List<Role> roles = mapper.selectAllRole(size, pageNum);
        return Responser.succeed().putData(roles);
    }
}
