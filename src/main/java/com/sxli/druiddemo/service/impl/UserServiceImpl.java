package com.sxli.druiddemo.service.impl;

import com.sxli.druiddemo.dao.UserDao;
import com.sxli.druiddemo.domain.User;
import com.sxli.druiddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(User user) {
        int result = userDao.save(user);
        return result > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public User getData(Long id) {
        User data = userDao.find(id);
        return data;
    }
}
