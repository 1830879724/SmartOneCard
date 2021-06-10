package com.cykj.dao;

import com.cykj.bean.MenuToal;

import java.util.List;

public interface MenuDao {
    public List<MenuToal> findMenuByRole(String role,Integer fid);

    public List<MenuToal> findMenuById(Integer zid);
}
