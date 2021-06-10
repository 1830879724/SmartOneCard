package com.cykj.service;

import com.cykj.bean.PersonTb;

public interface LoginService {
    public PersonTb login(String paccount, String ppassword);
}
