package com.feng.yaxin.authority.controller;

import com.feng.yaxin.authority.annotation.RestControllerMapping;
import com.feng.yaxin.authority.entity.RelAccountRole;
import com.feng.yaxin.authority.entity.Role;
import com.feng.yaxin.authority.mapper.RelAccountRoleMapper;
import com.feng.yaxin.authority.service.AccountService;
import com.feng.yaxin.authority.service.RelAccountRoleService;
import com.feng.yaxin.authority.utils.Responser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestControllerMapping("/api/account/role")
public class RelAccountRoleController {

    @Resource
    RelAccountRoleService accountRole;

    /**
     * 添加角色
     *
     * @param roleId    角色id
     * @param accountId 账户id
     */
    @PostMapping("/add")
    public Responser addRole(Integer roleId, Integer accountId) {
        accountRole.addRole(roleId, accountId);
        return Responser.succeed();
    }

    /**
     * 查询账户拥有的角色
     *
     * @param account 账户账号
     * @return 实体列表
     */
    @GetMapping("/query/account/{account}")
    public Responser query(@PathVariable String account) {
        List<Role> roles = accountRole.selectRoleByAccount(account);
        return Responser.succeed().putData(roles).put("size", roles.size());
    }

    /**
     * 查询账户拥有的角色
     *
     * @param id 账户账号
     * @return 实体列表
     */
    @GetMapping("/query/id/{id}")
    public Responser query(@PathVariable Integer id) {
        List<Role> roles = accountRole.selectRoleById(id);
        return Responser.succeed().putData(roles).put("size", roles.size());
    }

    /**
     * 修改账户对应的角色
     * @param accountId 账户id
     * @param roleId 角色id
     * @param newRoleId 新角色id
     */
    @PostMapping("/update")
    public Responser update(Integer accountId, Integer roleId, Integer newRoleId) {
        accountRole.update(accountId, roleId, newRoleId);
        return Responser.succeed();
    }

    /**
     * 删除账户对应的角色
     *
     * @param accountId 账户id
     * @param roleId    角色id
     */
    @DeleteMapping("/delete/{accountId}/{roleId}")
    public Responser delete(@PathVariable Integer accountId, @PathVariable Integer roleId) {
        accountRole.deleteRole(accountId, roleId);
        return Responser.succeed();
    }
}
