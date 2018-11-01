package com.test.mymall.commons;

import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

public class DBHelper {
	//객체 종료를 위한 공통사용 코드 메서드화
	public static Connection getConnection() throws Exception {
    	Connection connection = null;
		Context initContext = new InitialContext();
		DataSource dataSource = (DataSource)initContext.lookup("java:comp/env/jdbc/mall");
		connection = dataSource.getConnection();
		return connection;
	}
	//데이터베이스 연결을 위한 공통사용 코드 메서드화
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if(rs != null) {
            try {rs.close();} catch(Exception exception) {exception.printStackTrace();}
        }
        if(stmt != null) {
            try {stmt.close();} catch(Exception exception) {exception.printStackTrace();}
        }
        if(conn != null) {
            try {conn.close();} catch(Exception exception) {exception.printStackTrace();}
        }
	}
}
