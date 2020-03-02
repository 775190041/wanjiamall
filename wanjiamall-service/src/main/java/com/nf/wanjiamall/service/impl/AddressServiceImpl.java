package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.AddressDao;
import com.nf.wanjiamall.entity.AddressEntity;
import com.nf.wanjiamall.service.AddressService;
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
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public Object getAddressList(Integer pageNum, Integer pageSize, AddressEntity addressEntity) {
        List<AddressEntity> addressEntities = addressDao.getAddressList(pageNum,pageSize,addressEntity);
        return ResponseUtil.okList(addressEntities);
    }
}
