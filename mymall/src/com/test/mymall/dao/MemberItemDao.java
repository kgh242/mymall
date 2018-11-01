package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	/**
	 *  입력한 주문내역을 데이터베이스에 저장한다.
	 * 
	 * @param MemberItem 주문정보(member_no, item_no)
	 */
	public void insertMemberItem(MemberItem MemberItem) {
		System.out.println("MemberItemDao.insertMemberItem");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Member member = new Member();
		Item item = new Item();
		String sql = "INSERT INTO member_item(member_no, item_no, order_date) VALUES(?,?,now())";
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, member.getNo());
			preparedStatement.setInt(2, item.getNo());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(resultSet, preparedStatement, connection);
		}
	}
	
	/**
	 * HaspMap과 조인을 이용해 주문내역에 관한 검색문을 가져온다
	 * 
	 * @param	memberNo 주문한멤버의 No
	 * @return	조인된 주문내역(mi.no, mi.order_date, mi.item_no, i.name, i.price)
	 */
	//MemberItem INNER JOIN item 
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo){
		System.out.println("MemberItemDao.getMemberItemList()");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "SELECT mi.no, mi.item_no, i.name, i.price, mi.order_date FROM MemberItem mi INNER JOIN Item i on mi.item_no = i.no WHERE mi.member_no = ?";
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, memberNo);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("memberItemNo", resultSet.getInt(1));
				map.put("itemNo", resultSet.getInt(2));
				map.put("itemPrice", resultSet.getInt(3));
				map.put("itemName", resultSet.getString(4));
				map.put("orderDate", resultSet.getString(5));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(resultSet, preparedStatement, connection);
		}
		
		return list;
	}
	
}
