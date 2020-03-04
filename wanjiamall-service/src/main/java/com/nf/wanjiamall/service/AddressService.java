package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.AddressEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 南八
 */
public interface AddressService {
    Object getAddressList(Integer pageNum,Integer pageSize,AddressEntity addressEntity);
}
