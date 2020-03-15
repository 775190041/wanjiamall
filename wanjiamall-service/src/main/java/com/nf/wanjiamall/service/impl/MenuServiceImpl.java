package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.MenuDao;
import com.nf.wanjiamall.entity.MenuEntity;
import com.nf.wanjiamall.service.MenuService;
import com.nf.wanjiamall.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黑夜
 *
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService  {
    @Autowired
    private MenuDao menuDao;

    @Override
    public Object listMenu(Integer pageNum, Integer pageSize) {
        return ResponseUtil.okList(menuDao.listMenu(pageNum,pageSize));
    }

    @Override
    public Object insertMenu(MenuEntity menuEntity) {
        Integer count = menuDao.insertMenu(menuEntity);
        if (count>0){
            return ResponseUtil.ok("添加成功");
        }else {
            return ResponseUtil.fail(505,"添加失败");
        }
    }

    @Override
    public Object updateMenu(MenuEntity menuEntity) {
        Integer count = menuDao.updateMenu(menuEntity);
        if (count >0){
            return ResponseUtil.ok("修改成功");
        }else {
            return ResponseUtil.fail(505,"修改失败");
        }

    }

    @Override
    public Object deleteMenu(Integer id) {
        Integer count = menuDao.deleteMenu(id);
        if (count>0){
            return ResponseUtil.ok("删除成功");
        }else {
            return ResponseUtil.fail(505,"删除失败");
        }

    }

    @Override
    public Object getByIdMenu(Integer id) {
        return ResponseUtil.ok(menuDao.getByIdMenu(id));
    }
}
