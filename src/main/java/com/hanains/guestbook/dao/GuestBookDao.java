package com.hanains.guestbook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.guestbook.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 방명록 리스트 출력
	public List<GuestBookVo> getList(){
		List<GuestBookVo> list=sqlSession.selectList("guestbook.getbyGuestbookList");
		return list;
	}

	// 방명록 글쓰기
	public void insert(GuestBookVo vo){
		sqlSession.insert("guestbook.insert",vo);
	}

	// 방명록 삭제
	public void delete(Long no, String password){
		Map<String, Object> map=new HashMap<>();
		map.put("no",no);
		map.put("password", password);
		
		sqlSession.selectOne("guestbook.delete",map);
	}

	// 글쓴이 비밀번호 체크
	public String isPassword(Long no){
		String ispwd=sqlSession.selectOne("guestbook.getbyPassword",no);
		return ispwd;
	}
}