package com.cykj.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

    private static DBHelper dbHelper;

    private ComboPooledDataSource dataSource;
    private Properties properties;
    private Connection conn;
    private DBHelper(){

        dataSource = new ComboPooledDataSource("oracle");


    }
    public DataSource getDataSource(){
        return dataSource;
    }
    public synchronized static DBHelper getDbHelper(){
        if(dbHelper==null)
        {
            dbHelper=new DBHelper();
        }
        return dbHelper;
    }
    public Connection getConn() {

        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConnection(Connection conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
