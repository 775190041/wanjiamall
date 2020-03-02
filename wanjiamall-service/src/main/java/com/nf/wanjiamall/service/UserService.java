package com.nf.wanjiamall.service;

/**
 * @author 南八
 */
public interface UserService {
    Object getUserList(Integer pageNum,Integer pageSize,String username,String mobile);
}
