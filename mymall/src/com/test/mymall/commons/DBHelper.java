package com.test.mymall.commons;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBHelper {
	//객체 종료를 위한 공통사용 코드 메서드화
	public static SqlSession getSqlSession(){
		InputStream inputStream = null;
		try {
			String resource = "mybatis-config.xml";
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.commit();
		sqlSession.rollback();
		sqlSession.close();
		
		return sqlSession;
	}
}
