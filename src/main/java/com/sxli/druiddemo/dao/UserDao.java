package com.sxli.druiddemo.dao;

import com.sxli.druiddemo.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    int delete(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 获取全部用户
     *
     * @return
     */
    List<User> finAll();

    /**
     * 获取单个用户
     *
     * @param id
     * @return
     */
    User find(Long id);
}
