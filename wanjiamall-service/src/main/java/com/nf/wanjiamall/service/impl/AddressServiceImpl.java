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

    @Autowired(required = false)
    private AddressDao addressDao;

    @Override
    public Object getAddressList(Integer pageNum, Integer pageSize, AddressEntity addressEntity) {
        return ResponseUtil.okList(addressDao.getAddressList(pageNum,pageSize,addressEntity));
    }

    @Override
    public Object getAddressByUserId(Integer pageNum, Integer pageSize,  Integer userId) {
        List<AddressEntity> addressEntities = addressDao.getAddressByUserId(pageNum,pageSize,userId);
        return ResponseUtil.okList(addressEntities);
    }

    @Override
    public Object getAddressByIdAndUserId(Integer id, Integer userId) {
        AddressEntity addressEntity = addressDao.getAddressByIdAndUserId(id, userId);
        return ResponseUtil.ok(addressEntity);
    }

    @Override
    public Object addressInsert(AddressEntity addressEntity) {
        if (addressDao.addressInsert(addressEntity) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }
    }

    @Override
    public Object addressUpdate(Integer id, Integer userId, AddressEntity addressEntity) {
        if (addressDao.addressUpdate(id, userId, addressEntity) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }
    }

    @Override
    public Object addressDelete(Integer id, Integer userId) {
        if (addressDao.addressDelete(id, userId) > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }
    }
}
