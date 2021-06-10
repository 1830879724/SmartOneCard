package com.cykj.service.impl;

import com.cykj.bean.PersonTb;
import com.cykj.dao.LoginDao;
import com.cykj.service.LoginService;
import com.cykj.utils.ObjectFactory;

public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao = (LoginDao) ObjectFactory.getObject("com.cykj.dao.impl.LoginDaoImpl");

    @Override
    public PersonTb login(String paccount, String ppassword) {
        PersonTb personTb = null;
        personTb = loginDao.login(paccount,ppassword);
        return personTb;
    }
}
