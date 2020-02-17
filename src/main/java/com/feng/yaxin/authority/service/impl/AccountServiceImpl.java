package com.feng.yaxin.authority.service.impl;

import com.feng.yaxin.authority.entity.Account;
import com.feng.yaxin.authority.entity.Role;
import com.feng.yaxin.authority.mapper.AccountMapper;
import com.feng.yaxin.authority.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper mapper;

    @Override
    public void insertAccount(Account account) {
        mapper.insertAccount(account);
    }

    @Override
    public void deleteAccountByAccount(String account) {
        mapper.deleteAccountByAccount(account);
    }

    @Override
    public void updatePasswordByAccount(String account, String newPassword) {
        mapper.updatePasswordByAccount(account, newPassword);
    }

    @Override
    public Account selectAccountByAccount(String account) {
        return mapper.selectAccountByAccount(account);
    }

    @Override
    public List<Account> selectAllAccount(int size, int pageNum) {
        return mapper.selectAllAccount(size, (pageNum-1)*size);
    }
}
