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
}
