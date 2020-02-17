package com.feng.yaxin.authority.service;

import com.feng.yaxin.authority.entity.RelAccountRole;
import com.feng.yaxin.authority.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RelAccountRoleService {

    /**
     * 给账户添加角色
     *
     * @param accountId 账户id
     * @param roleId    角色id
     */
    void addRole(Integer roleId, Integer accountId);

    /**
     * 删除账户的角色
     *
     * @param roleId    角色id
     * @param accountId 账户id
     */
    void deleteRole(Integer accountId, Integer roleId);

    /**
     * 修改账户对应的角色
     * @param accountId 账户id
     * @param roleId 角色id
     * @param newRoleId 新角色id
     */
    void update(Integer accountId, Integer roleId, Integer newRoleId);


    /**
     * 查询某个账户拥有的角色
     * @param account 账户账号
     */
    List<Role> selectRoleByAccount(String account);

    /**
     * 查询某个账户拥有的角色
     * @param id 账户id
     */
    List<Role> selectRoleById(Integer id);

}
