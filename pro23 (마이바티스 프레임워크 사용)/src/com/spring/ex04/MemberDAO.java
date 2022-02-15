package com.spring.ex04;

import java.io.Reader;
import java.util.List;
import java.util.Map;

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
	public int insertMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=0;
		//지정한 id의 sql문에 memberVO의 값을 전달하여 회원 정보를 테이블에 추가
		result = session.insert("mapper.member.insertMember", memberVO);
		session.commit(); //수동 커밋이므로 반드시 commit()메서드를 호출하여 영구 반영
		return result;
	}
	public int insertMember2(Map<String,String>memberMap) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=session.insert("mapper.member.insertMember2",memberMap);
		session.commit();
		return result;
	}
	public int updateMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=session.update("mapper.member.updateMember",memberVO);
		session.commit();
		return result;
	}
	public int deleteMember(String id) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=0;
		result=session.delete("mapper.member.deleteMember",id);
		session.commit();
		return result;
	}
	public List searchMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("mapper.member.searchMember", memberVO);
		return list;
	}
	public List foreachSelect(List nameList) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("mapper.member.foreachSelect", nameList);
		return list;
	}
}
