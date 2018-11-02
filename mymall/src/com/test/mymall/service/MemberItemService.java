package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	private MemberItemDao memberItemDao;
	
	public void insertOrder(MemberItem memberItem) {
		System.out.println("MemberItemService.insertOrder()");
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			memberItemDao.insertMemberItem(connection, memberItem);
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(null, null, connection);
		}
	}
	
	public ArrayList<HashMap<String, Object>> getOrderList(int memberNo){
		System.out.println("MemberItemService.getOrderList()");
		Connection connection = null;
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			connection = DBHelper.getConnection();
			memberItemDao.getMemberItemList(connection, memberNo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(null, null, connection);
		}
		return list;
	}
}
