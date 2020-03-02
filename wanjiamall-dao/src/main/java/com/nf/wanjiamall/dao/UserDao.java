package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface UserDao {
    List<UserEntity> getUserList(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize,
                                 @Param("username") String username,@Param("mobile") String mobile);
}
