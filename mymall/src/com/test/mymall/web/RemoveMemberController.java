package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/RemoveMemberController")
public class RemoveMemberController extends HttpServlet {

	MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			memberService = new MemberService();
			Member member = (Member)session.getAttribute("loginMember");
			memberService.removeMember(member.getNo());
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}
	}

}
