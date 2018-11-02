package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	
	public ArrayList<Item> selectItem(HashMap<String, Integer> paging) {
		Connection connection = null;
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemDao = new ItemDao();
		try {
			connection = DBHelper.getConnection();
			itemList = itemDao.selectItemList(connection, paging);
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			DBHelper.close(null, null, connection);
		}
		return itemList;
	}
	
	public int getItemCount() {
		int count = 0;
		Connection connection = null;
		itemDao = new ItemDao();
		try {
			connection = DBHelper.getConnection();
			count = itemDao.getTotalItemCount(connection);
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			DBHelper.close(null, null, connection);
		}
		return count;
	}
}
