package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController에서 MemberService.removeMember()호출
	public void removeMember(int no) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBHelper.getConnection();
			connection.setAutoCommit(false); //자동 comit X
			// 1 function
			memberDao = new MemberDao();
			memberDao.deleteMember(connection, no);
			// 2 function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(connection, no);
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(resultSet, preparedStatement, connection);
		}
		
	}
	
	public void addMember(Member member) {
		memberDao = new MemberDao();
		memberDao.insertMember(new Member());	
	}
}
