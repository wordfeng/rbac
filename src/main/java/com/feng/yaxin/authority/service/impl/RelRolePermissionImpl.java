package com.feng.yaxin.authority.service.impl;

import com.feng.yaxin.authority.entity.Permission;
import com.feng.yaxin.authority.mapper.RelRolePermissionMapper;
import com.feng.yaxin.authority.service.RelRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RelRolePermissionImpl implements RelRolePermissionService {

    @Resource
    RelRolePermissionMapper arMapper;


    @Override
    public void addPermission(Integer roleId, Integer permissionId) {
        arMapper.addPermission(roleId, permissionId);
    }

    @Override
    public void deletePermission(Integer roleId, Integer permissionId) {
        arMapper.deletePermission(roleId, permissionId);
    }

    @Override
    public void update(Integer roleId, Integer permissionId, Integer newPermissionId) {
        arMapper.update(roleId, permissionId, newPermissionId);
    }

    @Override
    public List<Permission> selectPermissionByName(String roleName) {

        return arMapper.selectPermissionByName(roleName);
    }

    @Override
    public List<Permission> selectPermissionById(Integer roleId) {
        return arMapper.selectPermissionById(roleId);
    }
}
