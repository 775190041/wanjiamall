package com.nf.wanjiamall.service;


import com.nf.wanjiamall.entity.UserEntity;

/**
 * @author 南八
 */
public interface UserService {
    Object getUserList(Integer pageNum,Integer pageSize,String username,String mobile);
    Object userUpdate(int id, UserEntity userEntity);
}
