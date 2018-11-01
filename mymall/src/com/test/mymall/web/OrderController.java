package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	MemberItemDao memberItemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController.doGet()");
		HttpSession session = request.getSession();
		Member member = (Member)request.getSession().getAttribute("loginMember");
		if(member != null) {
			System.out.println("세션에 로그인된 아이디로 주문시작");
			int itemNo = Integer.parseInt(request.getParameter("itemNo"));
			int memberNo = member.getNo();
			memberItemDao = new MemberItemDao();
			MemberItem memberItem = new MemberItem();
			memberItem.setItem_no(itemNo);
			memberItem.setMember_no(memberNo);
			memberItemDao.insertMemberItem(memberItem);
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}
	}
}
