package com.feng.yaxin.authority.service.impl;

import com.feng.yaxin.authority.entity.Permission;
import com.feng.yaxin.authority.mapper.PermissionMapper;
import com.feng.yaxin.authority.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionMapper mapper;

    @Override
    public void insertPermission(Permission permission) {
        mapper.insertPermission(permission);
    }

    @Override
    public void deleteById(Integer id) {
        mapper.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        mapper.deleteByName(name);
    }

    @Override
    public void updatePermission(Permission permission) {
        mapper.updatePermission(permission);
    }

    @Override
    public Permission selectPermissionByName(String permissionName) {
        return mapper.selectPermissionByName(permissionName);
    }

    @Override
    public Permission selectPermissionById(Integer permissionId) {
        return mapper.selectPermissionById(permissionId);
    }

    @Override
    public List<Permission> selectAllPermission(int size, int pageNum) {
        return mapper.selectAllPermission(size, (pageNum - 1) * size);
    }
}
