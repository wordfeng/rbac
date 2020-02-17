package com.feng.yaxin.authority.mapper;

import com.feng.yaxin.authority.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AccountMapper {

    /**
     * 新增账户
     */
    void insertAccount(Account account);

    /**
     * 删除账户
     *
     * @param account 账户的账号
     */
    void deleteAccountByAccount(String account);

    /**
     * 修改密码
     *
     * @param account     账号
     * @param newPassword 新密码
     */
    void updatePasswordByAccount(String account, String newPassword);


    /**
     * 查询单个账户
     *
     * @param account 账户账号
     */
    Account selectAccountByAccount(String account);

    /**
     * 分页查询所有账户
     *
     * @param size    查询个数
     * @param pageNum 页数
     * @return 实体列表
     */
    List<Account> selectAllAccount(@Param("size") int size, @Param("pageNum") int pageNum);


}
