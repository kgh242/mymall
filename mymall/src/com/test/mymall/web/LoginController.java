package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private MemberDao memberDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		memberDao = new MemberDao();
		Member member = memberDao.login(null);
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", member);
	}

}
