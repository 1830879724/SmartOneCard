package com.cykj.service.impl;

import com.cykj.bean.MenuToal;
import com.cykj.dao.MenuDao;
import com.cykj.service.MenuService;
import com.cykj.utils.ObjectFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao = (MenuDao) ObjectFactory.getObject("com.cykj.dao.impl.MenuDaoImpl");


    @Override
    public Map<String, List<MenuToal>> findMenuByRole(String role, Integer fid) {
        List<MenuToal> menuToals = menuDao.findMenuByRole(role,0);
        HashMap<String,List<MenuToal>> menuMap = new HashMap();
        for (int i=0;i<menuToals.size();i++){
            MenuToal menuToal = menuToals.get(i);
            List<MenuToal> menuToalList = menuDao.findMenuByRole(role,menuToal.getZid().intValue());
            menuMap.put(menuToal.getPname(),menuToalList);
//            System.out.println("我是二级菜单长度："+menuToalList.size());
        }
        return menuMap;
    }
}
