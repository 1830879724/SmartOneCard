package com.cykj.service;

import com.cykj.bean.*;

import java.util.HashMap;

public interface AdminService {

    public String deleuser(String pname);

    public String setpwd(String pname);

    public PageBean<PersonTb> chaxun(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public String addpeople(String pname, String psection, String prole, String ppassword);

    public Boolean setpeople(String psection, String prole, String paccount);

    public PageBean<CardStorage> cardinsert(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<SaleTb> cardcancel(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<SaleTb> CardInquire(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<ApplyTb> CardGet(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<CardStorage> insertcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<SaleTb> cardcancelcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<SaleTb> CardInquirecx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<ApplyTb> CardGetcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public PageBean<ApplyTb> CardGets(HashMap<String, Object> condition, Integer curPage, Integer pageSize);
}
