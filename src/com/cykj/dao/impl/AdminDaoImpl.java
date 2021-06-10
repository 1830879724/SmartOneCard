package com.cykj.dao.impl;

import com.cykj.bean.*;
import com.cykj.dao.AdminDao;
import com.cykj.utils.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    //人员管理的删除
    @Override
    public String deleuser(String pname) {
        String flag = null;
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String  sql ="update PERSONTB set PSTATE= '已删除' where PNAME=?";
            QueryRunner qr=new QueryRunner();
            Object[] params={pname};
            int num=qr.update(conn,sql,params);
            if (num>0)  {
                flag="成功";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return flag;
    }
    //人员管理的重置密码
    @Override
    public String setpwd(String pname) {
        String flag = null;
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String  sql ="update PERSONTB set PPASSWORD= '123456' where PNAME=?";
            QueryRunner qr=new QueryRunner();
            Object[] params={pname};
            int num=qr.update(conn,sql,params);
            if (num>0)  {
                flag="成功";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return flag;
    }
    //人员管理的查询
    @Override
    public List<PersonTb> chaxun(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<PersonTb> list = new ArrayList<PersonTb>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql="select rn,PNAME,PSECTION,PROLE,PSTATE,PACCOUNT,PPASSWORD from(" +
                    "select ROWNUM rn ,t.* from (select * from PERSONTB where 1=1 ";
            if(condition.size()>0){
                if(condition.containsKey("pname")){
                    sql+=" and PNAME like '%"+condition.get("pname")+"%'";
                }if(condition.containsKey("psection")){
                    sql+=" and PSECTION like '%"+condition.get("psection")+"%'";
                }if(condition.containsKey("prole")){
                    sql+=" and PROLE like '%"+condition.get("prole")+"%'";
                }if(condition.containsKey("pstate")){
                    sql+=" and PSTATE like '%"+condition.get("pstate")+"%'";
                }
            }
            sql+="  order by persontb.pname)t) WHERE rn between ? and ?";

            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(PersonTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }
    //人员管理的页数
    @Override
    public Integer getTotal(HashMap<String, Object> condition) {
                Connection conn= DBHelper.getDbHelper().getConn();
                BigDecimal count=null;
                try {

                    String sql="select count(*) from PERSONTB where 1=1";
                    if(condition.size()>0){
                        if(condition.containsKey("pname")){
                            sql+=" and PNAME like '%"+condition.get("pname")+"%'";
                        }if(condition.containsKey("psection")){
                            sql+=" and PSECTION like '%"+condition.get("psection")+"%'";
                        }if(condition.containsKey("prole")){
                            sql+=" and PROLE like '%"+condition.get("prole")+"%'";
                        }if(condition.containsKey("pstate")){
                            sql+=" and PSTATE like '%"+condition.get("pstate")+"%'";
                        }
                    }
                    QueryRunner qr = new QueryRunner();
                    count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }

    //新增人员
    @Override
    public String addpeople(String pname, String psection, String prole, String ppassword) {

        String flag = null;
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql="insert into PERSONTB (PNAME,PSECTION,PROLE,PPASSWORD,PSTATE,PACCOUNT) values(?,?,?,?,'启用',SEQ_PERSONTB.nextval)";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,pname);
            pre.setString(2,psection);
            pre.setString(3,prole);
            pre.setString(4,ppassword);
            int num = pre.executeUpdate();
            flag = (num>0?"true":"false");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return flag;
    }

    //修改人员
    @Override
    public Boolean setpeople(String psection, String prole, String paccount) {
        int num=0;
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql="update PERSONTB set  PSECTION=?, PROLE=? where PACCOUNT = ?";
            QueryRunner qr=new QueryRunner();
            Object[] params={psection,prole,paccount};
            num=qr.update(conn,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return num>0;
    }

    //卡入库的
    @Override
    public List<CardStorage> cardinsert(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<CardStorage> list = new ArrayList<CardStorage>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql="select rn,CID,CRADID,CDATE,CSTATE from (" +
                    "select ROWNUM rn ,t.* from (select * from CARDSTORAGE where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("cid")){
                    sql+=" and CID like '%"+condition.get("cid")+"%'";
                }if(condition.containsKey("cradid")){
                    sql+=" and CRADID like '%"+condition.get("cradid")+"%'";
                }if(condition.containsKey("cdate")){
                    sql+=" and CDATE like '%"+condition.get("cdate")+"%'";
                }if(condition.containsKey("cstate")){
                    sql+=" and CSTATE like '%"+condition.get("cstate")+"%'";
                }
            }
            sql+="  order by CARDSTORAGE.CDATE DESC)t)  WHERE rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(CardStorage.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }
    //卡入库的分页
    @Override
    public Integer getTotalcard(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from CARDSTORAGE where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("cid")){
                    sql+=" and CID like '%"+condition.get("cid")+"%'";
                }if(condition.containsKey("cradid")){
                    sql+=" and CRADID like '%"+condition.get("cradid")+"%'";
                }if(condition.containsKey("cdate")){
                    sql+=" and CDATE like '%"+condition.get("cdate")+"%'";
                }if(condition.containsKey("cstate")){
                    sql+=" and CSTATE like '%"+condition.get("cstate")+"%'";
                }
            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }

    //注销卡的分页
    @Override
    public Integer getTotalcardcancel(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from SALETB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("sid")){
                    sql+=" and SID like '%"+condition.get("sid")+"%'";
                }if(condition.containsKey("scardid")){
                    sql+=" and SCARDID like '%"+condition.get("scardid")+"%'";
                }if(condition.containsKey("ssellp")){
                    sql+=" and SSELLP like '%"+condition.get("ssellp")+"%'";
                }if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }
            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }

    //注销卡
    @Override
    public List<SaleTb> cardcancel(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<SaleTb> list = new ArrayList<SaleTb>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql=" select rn, SID,SCARDID,SSELLP,SSTATE from(" +
                    " select ROWNUM rn ,t.* from (select * from SALETB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("sid")){
                    sql+=" and SID like '%"+condition.get("sid")+"%'";
                }if(condition.containsKey("scardid")){
                    sql+=" and SCARDID like '%"+condition.get("scardid")+"%'";
                }if(condition.containsKey("ssellp")){
                    sql+=" and SSELLP like '%"+condition.get("ssellp")+"%'";
                }if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }
            }
            sql+=" order by SALETB.SCARDID)t) WHERE rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(SaleTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }
    //查询卡的分页
    @Override
    public Integer getTotalCardInquire(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from SALETB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("aname")){
                    sql+=" and ANAME like '%"+condition.get("aname")+"%'";
                }if(condition.containsKey("scardid")){
                    sql+=" and SCARDID like '%"+condition.get("scardid")+"%'";
                }if(condition.containsKey("ssellp")){
                    sql+=" and SSELLP like '%"+condition.get("ssellp")+"%'";
                }if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }
            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }

    //查询卡
    @Override
    public List<SaleTb> CardInquire(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<SaleTb> list = new ArrayList<SaleTb>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql="select rn,aname,scardid,ssellp,sstate from(" + " select rownum rn,t.* from(" +
                    " select u.aname,s.scardid,s.ssellp,s.sstate from saletb s, usertb u where s.scardid=u.aaccount " ;
            if(condition.size()>0){
                if(condition.containsKey("aname")){
                    sql+=" and ANAME like '%"+condition.get("aname")+"%'";
                }if(condition.containsKey("scardid")){
                    sql+=" and SCARDID like '%"+condition.get("scardid")+"%'";
                }if(condition.containsKey("ssellp")){
                    sql+=" and SSELLP like '%"+condition.get("ssellp")+"%'";
                }if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }
            }

            sql+="order by s.scardid) t) " + "  where rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(SaleTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }

    //领卡审批的分页
    @Override
    public Integer getTotalCardGet(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from APPLYTB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("adate")){
                    sql+=" and ADATE like '%"+condition.get("adate")+"%'";
                }if(condition.containsKey("apeople")){
                    sql+=" and APEOPLE like '%"+condition.get("apeople")+"%'";
                }if(condition.containsKey("anum")){
                    sql+=" and ANUM like '%"+condition.get("anum")+"%'";
                }if(condition.containsKey("aauditp")){
                    sql+=" and AAUDITP like '%"+condition.get("aauditp")+"%'";
                }if(condition.containsKey("aauditdate")){
                    sql+=" and AAUDITDATE like '%"+condition.get("aauditdate")+"%'";
                }if(condition.containsKey("astate")){
                    sql+=" and ASTATE like '%"+condition.get("astate")+"%'";
                }
            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }
    //领卡审批
    @Override
    public List<ApplyTb> CardGet(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<ApplyTb> list = new ArrayList<ApplyTb>();
        Connection conn = DBHelper.getDbHelper().getConn();

        try {
            String sql="select rn,ADATE,APEOPLE,ANUM,AAUDITP,AAUDITDATE,ASTATE from(" +
                    "select ROWNUM rn ,t.* from (select * from APPLYTB where 1=1 " ;
            if(condition.size()>0){
                if(condition.containsKey("adate")){
                    sql+=" and ADATE like '%"+condition.get("adate")+"%'";
                }if(condition.containsKey("apeople")){
                    sql+=" and APEOPLE like '%"+condition.get("apeople")+"%'";
                }if(condition.containsKey("anum")){
                    sql+=" and ANUM like '%"+condition.get("anum")+"%'";
                }if(condition.containsKey("aauditp")){
                    sql+=" and AAUDITP like '%"+condition.get("aauditp")+"%'";
                }if(condition.containsKey("aauditdate")){
                    sql+=" and AAUDITDATE like '%"+condition.get("aauditdate")+"%'";
                }if(condition.containsKey("astate")){
                    sql+=" and ASTATE like '%"+condition.get("astate")+"%'";
                }
            }
            sql+=  "order by APPLYTB.ADATE DESC)t) WHERE rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(ApplyTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }
    //卡入库的带条件查询分页
    @Override
    public Integer getTotalinsertcx(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from CARDSTORAGE where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("cradid1")){
                    sql +=" and cradid > '"+condition.get("cradid1")+"'";
                }
                if(condition.containsKey("cradid2")){
                    sql += " and cradid < '"+condition.get("cradid2")+"'";
                }
                if(condition.containsKey("cdate1")){
                    sql +=" and cdate <= to_date('"+condition.get("cdate1")+"', 'yyyy-mm-dd')";
                }
                if(condition.containsKey("cdate2")){
                    sql +=" and cdate <= to_date('"+condition.get("cdate2")+"', 'yyyy-mm-dd')";
                }
                if(condition.containsKey("cstate")){
                    sql+=" and CSTATE like '%"+condition.get("cstate")+"%'";
                }

            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }
    //卡入库的带条件查询
    @Override
    public List<CardStorage> insertcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<CardStorage> list = new ArrayList<CardStorage>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql="select rn,CID,CRADID,CDATE,CSTATE from (" +
                    "select ROWNUM rn ,t.* from (select * from CARDSTORAGE where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("cradid1")){
                    sql +=" and cradid > '"+condition.get("cradid1")+"'";
                }
                if(condition.containsKey("cradid2")){
                    sql += " and cradid < '"+condition.get("cradid2")+"'";
                }
                if(condition.containsKey("cdate1")){
                    sql +=" and cdate <= to_date('"+condition.get("cdate1")+"', 'yyyy-mm-dd')";
                }
                if(condition.containsKey("cdate2")){
                    sql +=" and cdate <= to_date('"+condition.get("cdate2")+"', 'yyyy-mm-dd')";
                }
                if(condition.containsKey("cstate")){
                    sql+=" and CSTATE like '%"+condition.get("cstate")+"%'";
                }

            }
            sql+="  order by CARDSTORAGE.CDATE DESC)t)  WHERE rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(CardStorage.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }
    //卡注销的分页
    @Override
    public Integer getTotalcardcancelcx(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from SALETB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("scardid1")){
                    sql +=" and scardid > '"+condition.get("scardid1")+"'";
                }
                if(condition.containsKey("scardid2")){
                    sql += " and scardid < '"+condition.get("scardid2")+"'";
                }
                if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }

            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }
    //卡注销的查询
    @Override
    public List<SaleTb> cardcancelcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<SaleTb> list = new ArrayList<SaleTb>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql=" select rn, SID,SCARDID,SSELLP,SSTATE from(" +
                    " select ROWNUM rn ,t.* from (select * from SALETB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("scardid1")){
                    sql +=" and scardid > '"+condition.get("scardid1")+"'";
                }
                if(condition.containsKey("scardid2")){
                    sql += " and scardid < '"+condition.get("scardid2")+"'";
                }
                if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }

            }
            sql+=" order by SALETB.SCARDID)t) WHERE rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(SaleTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }
    //卡查询的带条件查询功能分页
    @Override
    public Integer getTotalCardInquirecx(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from SALETB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("scardid")){
                    sql+=" and SCARDID like '%"+condition.get("scardid")+"%'";
                }
                if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }
                if(condition.containsKey("ssellp")){
                    sql+=" and SSELLP like '%"+condition.get("ssellp")+"%'";
                }
            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }
    //卡查询的带条件查询功能
    @Override
    public List<SaleTb> CardInquirecx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<SaleTb> list = new ArrayList<SaleTb>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql="select rn,aname,scardid,ssellp,sstate from(" + " select rownum rn,t.* from(" +
                    " select u.aname,s.scardid,s.ssellp,s.sstate from saletb s, usertb u where s.scardid=u.aaccount " ;
            if(condition.size()>0){
                if(condition.containsKey("aname")){
                    sql+=" and ANAME like '%"+condition.get("aname")+"%'";
                }if(condition.containsKey("scardid")){
                    sql+=" and SCARDID like '%"+condition.get("scardid")+"%'";
                }if(condition.containsKey("ssellp")){
                    sql+=" and SSELLP like '%"+condition.get("ssellp")+"%'";
                }if(condition.containsKey("sstate")){
                    sql+=" and SSTATE like '%"+condition.get("sstate")+"%'";
                }
            }

            sql+="order by s.scardid) t) " + "  where rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(SaleTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }
    //领卡审批查询分页
    @Override
    public Integer getTotalCardGetcx(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from APPLYTB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("adate1")){
                    sql +=" and ADATE <= to_date('"+condition.get("adate1")+"', 'yyyy-mm-dd')";
                }   if(condition.containsKey("adate2")){
                    sql +=" and ADATE <= to_date('"+condition.get("adate2")+"', 'yyyy-mm-dd')";
                }if(condition.containsKey("apeople")){
                    sql+=" and APEOPLE like '%"+condition.get("apeople")+"%'";
                }if(condition.containsKey("anum")){
                    sql+=" and ANUM like '%"+condition.get("anum")+"%'";
                }if(condition.containsKey("aauditp")){
                    sql+=" and AAUDITP like '%"+condition.get("aauditp")+"%'";
                }if(condition.containsKey("aauditdate")){
                    sql+=" and AAUDITDATE like '%"+condition.get("aauditdate")+"%'";
                }if(condition.containsKey("astate")){
                    sql+=" and ASTATE like '%"+condition.get("astate")+"%'";
                }
            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }
    //领卡审批查询
    @Override
    public List<ApplyTb> CardGetcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<ApplyTb> list = new ArrayList<ApplyTb>();
        Connection conn = DBHelper.getDbHelper().getConn();

        try {
            String sql="select rn,ADATE,APEOPLE,ANUM,AAUDITP,AAUDITDATE,ASTATE from(" +
                    "select ROWNUM rn ,t.* from (select * from APPLYTB where 1=1 " ;
            if(condition.size()>0){
                if(condition.containsKey("adate1")){
                    sql +=" and ADATE >= to_date('"+condition.get("adate1")+"', 'yyyy-mm-dd')";
                }   if(condition.containsKey("adate2")){
                    sql +=" and ADATE <= to_date('"+condition.get("adate2")+"', 'yyyy-mm-dd')";
                }if(condition.containsKey("apeople")){
                    sql+=" and APEOPLE like '%"+condition.get("apeople")+"%'";
                }if(condition.containsKey("anum")){
                    sql+=" and ANUM like '%"+condition.get("anum")+"%'";
                }if(condition.containsKey("aauditp")){
                    sql+=" and AAUDITP like '%"+condition.get("aauditp")+"%'";
                }if(condition.containsKey("aauditdate")){
                    sql+=" and AAUDITDATE like '%"+condition.get("aauditdate")+"%'";
                }if(condition.containsKey("astate")){
                    sql+=" and ASTATE like '%"+condition.get("astate")+"%'";
                }
            }
            sql+=  "order by APPLYTB.ADATE DESC)t) WHERE rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(ApplyTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }

    //领卡的分页
    @Override
    public Integer getTotalCardGets(HashMap<String, Object> condition) {
        Connection conn= DBHelper.getDbHelper().getConn();
        BigDecimal count=null;
        try {

            String sql="select count(*) from APPLYTB where 1=1";
            if(condition.size()>0){
                if(condition.containsKey("adate1")){
                    sql +=" and ADATE >= to_date('"+condition.get("adate1")+"', 'yyyy-mm-dd')";
                }if(condition.containsKey("adate2")){
                    sql +=" and ADATE <= to_date('"+condition.get("adate2")+"', 'yyyy-mm-dd')";
                }if(condition.containsKey("astate")){
                    sql+=" and ASTATE like '%"+condition.get("astate")+"%'";
                }
            }
            QueryRunner qr = new QueryRunner();
            count=(BigDecimal) qr.query(conn,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return count.intValue();
    }
//领卡
    @Override
    public List<ApplyTb> CardGets(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        List<ApplyTb> list = new ArrayList<ApplyTb>();
        Connection conn = DBHelper.getDbHelper().getConn();

        try {
            String sql="select rn,ADATE,APEOPLE,ANUM,AAUDITP,AAUDITDATE,ASTATE from(" +
                    "select ROWNUM rn ,t.* from (select * from APPLYTB where 1=1 " ;
            if(condition.size()>0){
                if(condition.containsKey("adate1")){
                    sql +=" and ADATE >= to_date('"+condition.get("adate1")+"', 'yyyy-mm-dd')";
                }
                if(condition.containsKey("adate2")){
                    sql +=" and ADATE <= to_date('"+condition.get("adate2")+"', 'yyyy-mm-dd')";
                }if(condition.containsKey("apeople")){
                    sql+=" and APEOPLE like '%"+condition.get("apeople")+"%'";
                }if(condition.containsKey("anum")){
                    sql+=" and ANUM like '%"+condition.get("anum")+"%'";
                }if(condition.containsKey("aauditp")){
                    sql+=" and AAUDITP like '%"+condition.get("aauditp")+"%'";
                }if(condition.containsKey("aauditdate")){
                    sql+=" and AAUDITDATE like '%"+condition.get("aauditdate")+"%'";
                }if(condition.containsKey("astate")){
                    sql+=" and ASTATE like '%"+condition.get("astate")+"%'";
                }
            }
            sql+=  "order by APPLYTB.ADATE DESC)t) WHERE rn between ? and ?";
            QueryRunner qr = new QueryRunner();
            Object[] params={(curPage-1)*pageSize+1,curPage*pageSize};
            list = qr.query(conn,sql,new BeanListHandler<>(ApplyTb.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return list;
    }

}
