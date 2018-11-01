package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		Member member = (Member)request.getSession().getAttribute("loginMember");
		//int memberno = member.getNo();
		//MemberItemDao.insertMemberItem(MemberItem)
	}
}
