package com.nf.wanjiamall.service;

import com.nf.wanjiamall.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lzn
 */
@Service

public class DeptService {
    @Autowired
    private DeptDao deptDao;

    public int getDeptCount(){

        return deptDao.getCount();
    }
}
