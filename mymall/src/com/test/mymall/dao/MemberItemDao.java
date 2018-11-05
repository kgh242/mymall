package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	/**
	 *  입력한 주문내역을 데이터베이스에 저장한다.
	 * 
	 * @param memberItem 주문정보(member_no, item_no)
	 */
	public void insertMemberItem(SqlSession sqlSession, MemberItem memberItem) {
		System.out.println("Mybatis적용 주문.MemberItemDao");
		sqlSession.insert("com.test.mymall.dao.MemberItemMapper.orderInsert", memberItem);
	}	
	/**
	 * HaspMap과 조인을 이용해 주문내역에 관한 검색문을 가져온다
	 * 
	 * @param	memberNo 주문한멤버의 No
	 * @return	조인된 주문내역(mi.no, mi.order_date, mi.item_no, i.name, i.price)
	 */
	//MemberItem INNER JOIN item 
	public List<HashMap<String, Object>> getMemberItemList(SqlSession sqlSession, int memberNo){
		System.out.println("Mybatis적용 주문리스트.MemberItemDao");
		return sqlSession.selectList("com.test.mymall.dao.MemberItemMapper.orderList", memberNo);
	}
	//주문삭제 
	public void deleteMemberItem(SqlSession sqlSession, int no) {
		System.out.println("Mybatis적용 주문취소.MemberItemDao");
		sqlSession.delete("com.test.mymall.dao.MemberItemMapper.deleteMemberItem", no);
	}
}
