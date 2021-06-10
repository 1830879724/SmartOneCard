package com.cykj.dao;

import com.cykj.bean.*;

import java.util.HashMap;
import java.util.List;

public interface AdminDao {

    public String deleuser(String pname);

    public String setpwd(String pname);

    public List<PersonTb> chaxun(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public Integer getTotal(HashMap<String, Object> condition);

    public String addpeople(String pname, String psection, String prole, String ppassword);

    public Boolean setpeople(String psection, String prole, String paccount);

   public List<CardStorage> cardinsert(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public Integer getTotalcard(HashMap<String, Object> condition);

    public Integer getTotalcardcancel(HashMap<String, Object> condition);

    public List<SaleTb> cardcancel(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public Integer getTotalCardInquire(HashMap<String, Object> condition);

    public List<SaleTb> CardInquire(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public Integer getTotalCardGet(HashMap<String, Object> condition);

    public List<ApplyTb> CardGet(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public Integer getTotalinsertcx(HashMap<String, Object> condition);
    //卡入库的带条件查询
    public List<CardStorage> insertcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);
//卡注销的分页
    public Integer getTotalcardcancelcx(HashMap<String, Object> condition);
//卡注销的查询
    public List<SaleTb> cardcancelcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);
    //卡查询的带条件查询功能分页
    public Integer getTotalCardInquirecx(HashMap<String, Object> condition);
    //卡查询的带条件查询功能
    public List<SaleTb> CardInquirecx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);
//领卡审批查询的分页
   public Integer getTotalCardGetcx(HashMap<String, Object> condition);
    //领卡审批查询
    public List<ApplyTb> CardGetcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize);

    public Integer getTotalCardGets(HashMap<String, Object> condition);

    public List<ApplyTb> CardGets(HashMap<String, Object> condition, Integer curPage, Integer pageSize);
}
