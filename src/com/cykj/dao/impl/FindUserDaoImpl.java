package com.cykj.dao.impl;

import com.cykj.bean.PersonTb;
import com.cykj.dao.FindUserDao;
import com.cykj.utils.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindUserDaoImpl implements FindUserDao {
    @Override
    public List<PersonTb> findAll(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
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
                }if(condition.containsKey("paccount")){
                    sql+=" and PACCOUNT like '%"+condition.get("paccount")+"%'";
                }
            }
            sql+="  order by persontb.paccount)t) WHERE rn between ? and ?";

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


    @Override
    public Integer findCount(HashMap<String, Object> condition) {
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
                }if(condition.containsKey("paccount")){
                    sql+=" and PACCOUNT like '%"+condition.get("paccount")+"%'";
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
}
