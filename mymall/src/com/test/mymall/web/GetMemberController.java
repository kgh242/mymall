package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/GetMemberController")
public class GetMemberController extends HttpServlet {
	private MemberDao memberDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetMemberController.doGet()");
		String id = request.getParameter("id");
		this.memberDao = new MemberDao();
		Member member = this.memberDao.selectMember(id);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/getMember.jsp").forward(request, response);
	}
}
