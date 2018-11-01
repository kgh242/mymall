package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	//컨트롤러의 역할
	//1. 라우터
	//2. 모델호출
	//3. 뷰 렌더링
	private MemberDao memberDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("WEB-INF/views/addMember.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		this.memberDao = new MemberDao();
		Member member = new Member();
		String id =  request.getParameter("id");
		String pw = request.getParameter("pw");
		int level = Integer.parseInt(request.getParameter("level"));
		member.setId(id);
		member.setPw(pw);
		member.setLevel(level);
		int row = this.memberDao.insertMember(member);
		response.sendRedirect(request.getContextPath()+"/IndexController");
	
	}

}
