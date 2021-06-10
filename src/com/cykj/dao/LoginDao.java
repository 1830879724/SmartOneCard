package com.cykj.dao;

import com.cykj.bean.PersonTb;

public interface LoginDao {
    public PersonTb login(String paccount,String ppassword);
}
