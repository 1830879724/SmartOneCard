package com.cykj.service;

import com.cykj.bean.PageBean;
import com.cykj.bean.PersonTb;

import java.util.HashMap;

public interface FindUserService {
    public PageBean<PersonTb> findAll(HashMap<String,Object> condition, Integer curPage, Integer pageSize);

}
