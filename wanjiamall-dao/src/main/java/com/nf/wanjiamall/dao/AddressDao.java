package com.nf.wanjiamall.dao;

import com.nf.wanjiamall.entity.AddressEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface AddressDao {

    List<AddressEntity> getAddressList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                       @Param("addressEntity") AddressEntity addressEntity);

    /**
     * 用户默认地址
     */
    AddressEntity  getAddressDefault(@Param("userId") Integer userId);

    /**
     * 根据用户id与地址id查询地址信息
     */
    AddressEntity getAddressIdAndUserIdQuery(@Param("userId")Integer userId,@Param("addressId")Integer addressId);
}
