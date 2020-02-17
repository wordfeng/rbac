package com.feng.yaxin.authority.service.impl;

import com.feng.yaxin.authority.entity.Role;
import com.feng.yaxin.authority.mapper.RoleMapper;
import com.feng.yaxin.authority.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper mapper;

    @Override
    public void insertRole(Role role) {
        mapper.insertRole(role);
    }

    @Override
    public void updateRole(Role role) {
        mapper.updateRole(role);
    }

    @Override
    public void deleteRoleByName(String roleName) {
        mapper.deleteRoleByName(roleName);
    }

    @Override
    public Role selectRoleByName(String roleName) {
        return mapper.selectRoleByName(roleName);
    }

    @Override
    public List<Role> selectAllRole(int size, int pageNum) {
        return mapper.selectAllRole(size, (pageNum - 1) * size);
    }
}
