package com.feng.yaxin.authority.controller;

import com.feng.yaxin.authority.annotation.RestControllerMapping;
import com.feng.yaxin.authority.ao.AccountAo;
import com.feng.yaxin.authority.ao.CreateAccountAo;
import com.feng.yaxin.authority.entity.Account;
import com.feng.yaxin.authority.service.AccountService;
import com.feng.yaxin.authority.utils.Responser;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@RestControllerMapping("/api/account")
public class AccountController {

    @Resource
    AccountService acService;

    /**
     * 创建账户
     */
    @PostMapping("/create")
    public Responser create(@Valid CreateAccountAo ao, HttpServletRequest req) {
        Account account = new Account();
        account.setAccount(ao.getAccount());
        account.setName(ao.getName());
        account.setPassword(ao.getPassword());
        account.setCreateTime(LocalDateTime.now());
//        HttpSession session = req.getSession();
//        account.setCreateUserId(((Account) session.getAttribute("userInfo")).getId());
        acService.insertAccount(account);
        return Responser.succeed();
    }

    /**
     * 删除账户
     */
    @DeleteMapping("/delete/{account}")
    public Responser delete(@PathVariable String account) {
        acService.deleteAccountByAccount(account);
        return Responser.succeed();
    }

    /**
     * 修改账户
     */
    @PostMapping("/modify")
    public Responser modify(AccountAo ao, String oldPassword) {
        Account account = acService.selectAccountByAccount(ao.getAccount());
        if (!account.getPassword().equals(oldPassword)) {
            return Responser.fail();
        }
        acService.updatePasswordByAccount(ao.getAccount(), ao.getPassword());
        return Responser.succeed();
    }

    /**
     * 查询单个账户
     *
     * @param account 账户账号
     */
    @GetMapping("/query/{account}")
    public Responser query(@PathVariable String account) {
        Account result = acService.selectAccountByAccount(account);
        return Responser.succeed().putData(result);
    }

    /**
     * 分页查询账户表
     *
     * @param size    每页数据行数
     * @param pageNum 页数
     */
    @GetMapping("/query/{size}/{pageNum}")
    public Responser query(@PathVariable int size, @PathVariable int pageNum) {
        List<Account> list = acService.selectAllAccount(size, pageNum);
        return Responser.succeed().putData(list).put("size", list.size());
    }

}
