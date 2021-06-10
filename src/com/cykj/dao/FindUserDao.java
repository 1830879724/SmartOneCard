package com.cykj.dao;

import com.cykj.bean.PersonTb;

import java.util.HashMap;
import java.util.List;

public interface FindUserDao {

    public List<PersonTb> findAll(HashMap<String,Object> condition, Integer curPage, Integer pageSize);

    public Integer findCount(HashMap<String,Object> condition);
}
