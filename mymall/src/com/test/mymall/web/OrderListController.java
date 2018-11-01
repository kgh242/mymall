package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberItemDao;

@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	MemberItemDao memberItemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController doGet()");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			memberItemDao = new MemberItemDao();
			int memberNo = Integer.parseInt(request.getParameter("memberNo"));
			ArrayList<HashMap<String,Object>> list = memberItemDao.getMemberItemList(memberNo);
			request.setAttribute("memberItemList", list);
			request.getRequestDispatcher("/WEB-INF/views/orderList.jsp").forward(request, response);
		}
	}

}
