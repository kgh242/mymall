package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController에서 MemberService.removeMember()호출
	public void removeMember(int no) {
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			// 1 function
			memberDao = new MemberDao();
			memberDao.deleteMember(sqlSession, no);
			// 2 function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(sqlSession, no);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		
	}
	
	//회원가입
	public void addMember(Member member) {
		System.out.println("회원가입.MemberService");
		SqlSession sqlSession = null;
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao.insertMember(sqlSession, member);
			sqlSession.commit();
		}
		catch(Exception e) {
			sqlSession.rollback();
		}
		finally {
			sqlSession.close();
		}
	}
	
	public Member login(Member member) {
		System.out.println("로그인.MemberService");
		SqlSession sqlSession = null;
		Member memberLogin = new Member();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberLogin = memberDao.login(sqlSession, member);
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			sqlSession.close();
		}
		return memberLogin;
	}
	//회원체크
	public Member getMember(String id) {
		System.out.println("회원체크.MemberService");
		SqlSession sqlSession = null;
		Member member = new Member();
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			member = memberDao.selectMember(sqlSession, id);
			sqlSession.commit();
		} 
		catch(Exception e) {
			sqlSession.rollback();
		}
		finally {
			sqlSession.close();
		}
		return member;
	}
	
	//회원수정
	public void modifyMember(Member member) {
		System.out.println("회원수정.MemberService");
		SqlSession sqlSession = null;
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao.modifyMember(sqlSession, member);
			sqlSession.commit();
		}
		catch(Exception e) {
			sqlSession.rollback();
		}
		finally {
			sqlSession.close();
		}
	}
}
