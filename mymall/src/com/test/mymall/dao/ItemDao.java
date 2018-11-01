package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.Member;

public class ItemDao {
	/**
	 * 현재 페이지에서 한 페이지에 보여지는 개수만큼 물품정보를 데이터베이스에서 가져온다
	 * 
	 * @return 물품정보(Item)의 리스트
	 * @param currentPage 현재 보여지는 페이지의 번호
	 * @param rowPerPage 한 페이지에 보여지는 아이템의 개수
	 */
	public ArrayList<Item> selectItemList(int currentPage,int rowPerPage) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("SELECT no, name, price FROM item LIMIT ? , ?");
			preparedStatement.setInt(1, (currentPage - 1) * rowPerPage);
			preparedStatement.setInt(2, rowPerPage);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Item item = new Item();
				item.setNo(resultSet.getInt(1));
				item.setName(resultSet.getString(2));
				item.setPrice(resultSet.getInt(3));
				itemList.add(item);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(resultSet, preparedStatement, connection);
		}
		return itemList;
	}
	/**
	 * 데이터베이스에서 물품의 총 개수를 얻어온다
	 * 
	 * @return 물품의 총 개수
	 */
	public int getTotalItemCount() {
		int totalCount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("SELECT count(*) FROM item");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				totalCount = resultSet.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(resultSet, preparedStatement, connection);
		}
		return totalCount;
	}
}
