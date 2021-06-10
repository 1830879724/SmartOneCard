package com.cykj.service.impl;

import com.cykj.dao.UpdateDao;
import com.cykj.service.UpdateService;
import com.cykj.utils.ObjectFactory;

public class UpdateServiceImpl implements UpdateService {
    private UpdateDao updateDao = (UpdateDao) ObjectFactory.getObject("com.cykj.dao.impl.UpdateDaoImpl");

    @Override
    public Boolean findUpdate(String pname, String pstate) {
        Boolean flag = false;
        flag=updateDao.findUpdate(pname,pstate);
        return flag;
    }
}
