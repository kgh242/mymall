package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	private MemberItemDao memberItemDao;
	
	public void insertOrder(MemberItem memberItem) {
		System.out.println("mybatis적용 주문.MemberItemService");
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberItemDao.insertMemberItem(sqlSession, memberItem);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
		}
		finally {
			sqlSession.close();
		}
	}
	
	public List<HashMap<String, Object>> getOrderList(int memberNo){
		System.out.println("mybatis적용 주문리스트.MemberItemService");
		SqlSession sqlSession = null;
		List<HashMap<String, Object>> list = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberItemDao = new MemberItemDao();
			list = memberItemDao.getMemberItemList(sqlSession, memberNo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sqlSession.close();
		}
		return list;
	}
}
