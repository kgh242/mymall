package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	/** 
	 * 폼에서 입력한 멤버의 정보를 데이터베이스에 등록
	 * 
	 * @param Member 폼에서 입력한 멤버의 정보(id,pw,level)
	 */
	//회원가입을 위한 메서드
	public int insertMember(Member member) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int rows = 0;
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("insert into member(id,pw,level) values(?,?,?)");
			preparedStatement.setString(1, member.getId());
			preparedStatement.setString(2, member.getPw());
			preparedStatement.setInt(3, member.getLevel());
			rows = preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(resultSet,preparedStatement,connection);
		}
		return rows;
	}
	//id와 pw값을 가지는 member객체를 이용해 로그인체크를 하는 메서드
	//id와pw일치시 success = true 리턴
	public boolean login(Member member) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean success = false;
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("SELECT id from member where id = ? and pw = ?");
			preparedStatement.setString(1, member.getId());
			preparedStatement.setString(2, member.getPw());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				success = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(resultSet,preparedStatement,connection);
		}		
		return success;
	}
	/**
	 * 데이터베이스에서 로그인된 회원의 id에 해당하는 회원정보를 가져온다
	 * 
	 * @param	id	로그인된 회원의 id
	 * @return	회원의정보(no,id,pw,level)
	 */
	public Member selectMember(String id) {
		System.out.println("MemberDao.selectMember()");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Member member = new Member();
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("SELECT no, id, pw, level from member WHERE id = ?");
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			member.setNo(resultSet.getInt(1));
			member.setId(resultSet.getString(2));
			member.setPw(resultSet.getString(3));
			member.setLevel(resultSet.getInt(4)); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(resultSet, preparedStatement, connection);
		}	
		return member;
	}
    /**
     * 매개변수로전달된 로그인한 회원의 수정된 데이터(member)를 데이터베이스에서 갱신
     *
     * @param   member   로그인한 회원의 수정된 데이터(pw,level)
     * @return  없음
     */
	public void modifyMember(Member member) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBHelper.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE member SET pw = ?, level = ? WHERE id = ?");
			preparedStatement.setString(1, member.getPw());
			preparedStatement.setInt(2, member.getLevel());
			preparedStatement.setString(3, member.getId());
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBHelper.close(null, preparedStatement, connection);
		}	
	}
	
	public void deleteMember(int no) {
		
	}
}
