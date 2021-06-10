package com.cykj.dao.impl;

import com.cykj.bean.MenuToal;
import com.cykj.dao.MenuDao;
import com.cykj.utils.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {


    @Override
    public List<MenuToal> findMenuByRole(String role, Integer fid) {
        List<MenuToal> menuToals = new ArrayList<MenuToal>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql = "SELECT B.ZID,B.PNAME,B.FID,B.URL FROM MENUTOAL B,MENUROLE A WHERE A.PID=B.ZID AND B.FID=? AND ROLE=?";
            QueryRunner qr=new QueryRunner();
            Object[] params={fid,role};
            menuToals= qr.query(conn,sql,new BeanListHandler<>(MenuToal.class),params);
//            System.out.println("changdu="+menuToals.size());
//            System.out.println(fid+":"+role);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return menuToals;
    }

    @Override
    public List<MenuToal> findMenuById(Integer zid){
        List<MenuToal> menuToals = new ArrayList<MenuToal>();
        Connection conn = DBHelper.getDbHelper().getConn();
        try {
            String sql = "SELECT B.* FROM MENUTOAL B,MENUROLE A WHERE B.ZID = ? and A.PID = b.FID";
            QueryRunner qr=new QueryRunner();
            Object[] params={zid};
            menuToals= qr.query(conn,sql,new BeanListHandler<>(MenuToal.class),params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBHelper.getDbHelper().closeConnection(conn);
        }
        return menuToals;

    }
}
