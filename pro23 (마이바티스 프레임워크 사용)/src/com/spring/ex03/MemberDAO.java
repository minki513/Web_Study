package com.spring.ex03;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper=null;
	
	private static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource="mybatis/SqlMapConfig.xml";
				Reader reader=Resources.getResourceAsReader(resource);
				sqlMapper=new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	public List<MemberVO> selectAllMemberList(){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		List<MemberVO> memlist=null;
		memlist=session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	public MemberVO selectMemberById(String id) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		//서블릿에서 넘어온 id의 갑승ㄹ selectOne()메서드 호출 시 해당 sql문의 조건 값으로 전달
		//selectOne -레코드 한개만 조회할 때 사용
		MemberVO memberVO=(MemberVO) session.selectOne("mapper.member.selectMemberById",id);
		return memberVO;
	}
	public List<MemberVO> selectMemberByPwd(int pwd){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		List<MemberVO> membersList=null;
		//비밀번호가 같은 회원은 여러명이 있을 수 있으므로 selectList()메서드로 조회
		membersList=session.selectList("mapper.member.selectMemberByPwd",pwd);
		return membersList;
	}
}
