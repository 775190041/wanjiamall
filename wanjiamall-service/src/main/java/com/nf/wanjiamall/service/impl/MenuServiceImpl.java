package com.nf.wanjiamall.service.impl;

import com.nf.wanjiamall.dao.MenuDao;
import com.nf.wanjiamall.entity.MenuEntity;
import com.nf.wanjiamall.service.MenuService;
import com.nf.wanjiamall.utils.ResponseUtil;
import com.nf.wanjiamall.vo.MenuNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑夜
 *
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService  {
    @Autowired(required = false)
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
    public Object updateMenu(Integer id,MenuEntity menuEntity) {
        Integer count = menuDao.updateMenu(id,menuEntity);
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
    public Object getByIdMenu(Integer pid) {
        return ResponseUtil.ok(menuDao.getByIdMenu(pid));
    }

    @Override
    public Object getByLevelMenu(Integer level) {
        return ResponseUtil.ok(menuDao.getByLevelMenu(level));
    }

    @Override
    public Object treeList() {
        List<MenuEntity> menuEntities = menuDao.getByLevelMenu(1);
        List<MenuNode> menuNodes = new ArrayList<>(menuEntities.size());
        for (MenuEntity menuEntity : menuEntities) {
            MenuNode menuNode = new MenuNode();
            menuNode.setId(menuEntity.getId());
            menuNode.setPid(menuEntity.getParentId());
            menuNode.setLabel(menuEntity.getTitle());

            List<MenuEntity> menuEntities1 = menuDao.getByIdMenu(menuEntity.getId());
            List<MenuNode> children = new ArrayList<>(menuEntities1.size());
            for (MenuEntity entity : menuEntities1) {
                MenuNode menuNode1 = new MenuNode();
                menuNode1.setId(entity.getId());
                menuNode1.setPid(entity.getParentId());
                menuNode1.setLabel(entity.getTitle());
                children.add(menuNode1);
            }
            menuNode.setChildren(children);
            menuNodes.add(menuNode);
        }
        return ResponseUtil.ok(menuNodes);
    }
}
