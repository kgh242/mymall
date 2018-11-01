package com.test.mymall.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberItemDao {
	//MemberItem INNER JOIN item 
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price FROM MemberItem mi INNER JOIN Item i on mi.item_no = i.no WHERE mi.member_no = ?";
		ResultSet rs = null;
		while(rs.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("mi.no"));
			map.put("memberItemNo", rs.getInt("i.price"));
			list.add(map);
		}
		return list;
	}
}
