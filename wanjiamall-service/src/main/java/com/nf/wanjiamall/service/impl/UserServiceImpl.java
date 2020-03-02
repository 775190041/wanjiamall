package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.UserDao;
import com.nf.wanjiamall.entity.UserEntity;
import com.nf.wanjiamall.service.UserService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 南八
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Object getUserList(Integer pageNum, Integer pageSize, String username, String mobile) {
        List<UserEntity> userEntities = userDao.getUserList(pageNum, pageSize, username, mobile);
        return ResponseUtil.okList(userEntities);
    }
}
