package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	
	public ArrayList<Item> selectItem(HashMap<String, Integer> paging, int currentPage, int rowPerPage, int pagePerScreen) {
		int totalCount; //전체 게시물수
		int currentScreen; //현재 화면 번호
		int lastScreen; //마지막 화면 번호
		int startScreenPage; //현재 화면의 페이지 시작번호
		int currentScreenPage; //현재 화면에 보이는 페이지 수
		int lastPage; //마지막 페이지번호
		SqlSession sqlSession = null;
		ArrayList<Item> itemList = null;
		itemDao = new ItemDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			itemList = (ArrayList<Item>)itemDao.selectItemList(sqlSession, paging);
			paging.put("currentPage", (currentPage-1)*rowPerPage);
			paging.put("rowPerPage", rowPerPage);
			
			totalCount = itemDao.getTotalItemCount(sqlSession);
			lastPage = (int)Math.ceil((double)totalCount/rowPerPage);
			currentScreen = (int)Math.ceil((double)currentPage/pagePerScreen);
			lastScreen = (int)Math.ceil((double)totalCount/(rowPerPage*pagePerScreen));
			startScreenPage = (currentScreen-1)*pagePerScreen+1;
			if(currentScreen == lastScreen) {
				if(totalCount % (rowPerPage * pagePerScreen) != 0) { //마지막 화면에 보이는 리스트 개수(rowPerPage * pagePerScreen)가 100개이면 totalCount % (rowPerPage * pagePerScreen)은 0이 되기때문에 pagePerScreen 값을 넣어주어야 한다
					int temp = totalCount % (rowPerPage * pagePerScreen);
					currentScreenPage = (int) Math.ceil((double) temp / rowPerPage);
				}
				else {
					currentScreenPage = pagePerScreen;
				}
			}
			else {
				currentScreenPage = pagePerScreen;
			}
			paging.put("currentPage", currentPage);
			paging.put("lastPage", lastPage);
			paging.put("currentScreen", currentScreen);
			paging.put("lastScreen", lastScreen);
			paging.put("pagePerScreen", pagePerScreen);
			paging.put("currentScreenPage", currentScreenPage);
			paging.put("startScreenPage", startScreenPage);
			
			sqlSession.commit();
		} catch(Exception e){
			sqlSession.rollback();
		}
		finally {
			sqlSession.close();
		}
		return itemList;
	}
}