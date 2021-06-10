package com.cykj.dao.impl;

import com.cykj.dao.UpdateDao;
import com.cykj.utils.DBHelper;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateDaoImpl implements UpdateDao {
    @Override
    public Boolean findUpdate(String pname, String pstate) {
        Boolean flag = false;
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String  sql ="update PERSONTB set PSTATE= ? where PNAME=?";
            QueryRunner qr=new QueryRunner();
            Object[] params={pstate,pname};
            int num=qr.update(conn,sql,params);
            if (num>0)  {
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return flag;
    }
}

