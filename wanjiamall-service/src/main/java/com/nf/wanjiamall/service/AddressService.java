package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.AddressEntity;
import org.apache.ibatis.annotations.Param;


/**
 * @author 南八
 */
public interface AddressService {

    Object getAddressList(Integer pageNum,Integer pageSize,AddressEntity addressEntity);
    Object getAddressByUserId(Integer pageNum,Integer pageSize, Integer userId);
    Object getAddressByIdAndUserId(Integer id, Integer userId);
    Object addressInsert(AddressEntity addressEntity);
    Object addressUpdate(Integer id,Integer userId,AddressEntity addressEntity);
    Object addressDelete(Integer id,Integer userId);
}
