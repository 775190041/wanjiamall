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

    List<AddressEntity> getAddressByUserId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                                       @Param("userId") Integer userId);

    AddressEntity getAddressByIdAndUserId(@Param("id") Integer id,@Param("userId") Integer userId);
    int addressInsert(@Param("addressEntity") AddressEntity addressEntity);
    int addressUpdate(@Param("id") Integer id,@Param("userId") Integer userId,AddressEntity addressEntity);
    int addressDelete(@Param("id") Integer id,@Param("userId") Integer userId);

    /**
     * 用户默认地址
     */
    AddressEntity  getAddressDefault(@Param("userId") Integer userId);

    /**
     * 根据用户id与地址id查询地址信息
     */
    AddressEntity getAddressIdAndUserIdQuery(@Param("userId")Integer userId,@Param("addressId")Integer addressId);

    /**
     * 根据用户Id查询该用户所有地址
     */
    List<AddressEntity> getUserIdAddressAll(@Param("userId")Integer userId);
}
