package com.sxli.druiddemo.service;

import com.sxli.druiddemo.domain.User;

public interface UserService {

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 获取用户数据
     *
     * @param id
     * @return
     */
    User getData(Long id);
}
