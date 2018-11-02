package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.ItemService;
import com.test.mymall.vo.Item;

@WebServlet("/ItemListController")
public class ItemListController extends HttpServlet {
	ItemService itemService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("ItemListController.doGet()");
		int currentPage = 1; //현재 페이지 번호
		int rowPerPage = 10; //페이지당 보이는 리스트 개수
		int pagePerScreen = 10; //한 화면당 보이는 페이지 개수
		int totalCount;
		int currentScreen; //현재 화면 번호
		int lastScreen; //마지막 화면 번호
		int currentScreenPage; //현재 화면에 보이는 페이지의 개수
		int startScreenPage; //현재 화면에 보이는 페이지의 시작 번호(첫번째화면 1,두번째화면 11..)
		int lastPage; //마지막 페이지번호
		itemService = new ItemService();
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		totalCount = itemService.getItemCount();
		lastPage = (int)Math.ceil((double) totalCount / rowPerPage);
		currentScreen = (int)Math.ceil((double) currentPage / rowPerPage);
		lastScreen = (int) Math.ceil((double) totalCount / (rowPerPage * pagePerScreen));
		startScreenPage = (currentScreen - 1) * pagePerScreen;
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
		HashMap<String, Integer> paging = new HashMap<String, Integer>();
		ArrayList<Item> itemList = itemService.selectItem(paging);
		request.setAttribute("paging", paging);
		request.setAttribute("itemList", itemList);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("currentScreen", currentScreen);
		request.setAttribute("lastScreen", lastScreen);
		request.setAttribute("pagePerScreen", pagePerScreen);
		request.setAttribute("currentScreenPage", currentScreenPage);
		request.setAttribute("startScreenPage", startScreenPage);
		request.getRequestDispatcher("WEB-INF/views/itemList.jsp").forward(request, response);
	}

}
