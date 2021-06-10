package com.cykj.service.impl;

import com.cykj.bean.PageBean;
import com.cykj.bean.PersonTb;
import com.cykj.dao.FindUserDao;
import com.cykj.service.FindUserService;
import com.cykj.utils.ObjectFactory;

import java.util.HashMap;
import java.util.List;

public class FindUserServiceImpl implements FindUserService {
    private FindUserDao findUserDao = (FindUserDao) ObjectFactory.getObject("com.cykj.dao.impl.FindUserDaoImpl");

    @Override
    public PageBean<PersonTb> findAll(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalRecords = findUserDao.findCount(condition);
        PageBean<PersonTb> pageBean= new PageBean<>(curPage,totalRecords,pageSize);
        List<PersonTb> userList = findUserDao.findAll(condition,curPage,pageSize);
        pageBean.setList(userList);
        return pageBean;
    }
}
