package com.feng.yaxin.authority.service.impl;

import com.feng.yaxin.authority.entity.RelAccountRole;
import com.feng.yaxin.authority.entity.Role;
import com.feng.yaxin.authority.mapper.RelAccountRoleMapper;
import com.feng.yaxin.authority.service.RelAccountRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RelAccountRoleServiceImpl implements RelAccountRoleService {


    @Resource
    RelAccountRoleMapper mapper;

    @Override
    public void addRole(Integer roleId, Integer accountId) {
        mapper.addRole(roleId, accountId);
    }

    @Override
    public void deleteRole(Integer accountId, Integer roleId) {
        mapper.deleteRole(accountId, roleId);
    }

    @Override
    public void update(Integer accountId, Integer roleId, Integer newRoleId) {
        mapper.update(accountId, roleId, newRoleId);
    }

    @Override
    public List<Role> selectRoleByAccount(String account) {
        return mapper.selectRoleByAccount(account);
    }

    @Override
    public List<Role> selectRoleById(Integer id) {
        return mapper.selectRoleById(id);
    }
}
