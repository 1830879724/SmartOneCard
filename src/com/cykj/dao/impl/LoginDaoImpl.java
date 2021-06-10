package com.cykj.dao.impl;

import com.cykj.bean.PersonTb;
import com.cykj.dao.LoginDao;
import com.cykj.utils.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

public class LoginDaoImpl implements LoginDao {

    @Override
    public PersonTb login(String paccount, String ppassword) {
        PersonTb personTb = null;
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql = "select * from PERSONTB where paccount=? and ppassword=? ";
            Object[] params = {paccount,ppassword};
            QueryRunner qr = new QueryRunner();
            personTb  = qr.query(conn,sql,new BeanHandler<>(PersonTb.class),params);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return personTb;
    }
}
