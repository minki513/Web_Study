package com.spring.ex01;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MemberDAO {
	public static SqlSessionFactory sqlMapper=null;
	
	private static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource="mybatis/SqlMapConfig.xml"; //MemberDAO의 각 메서드 호출 시 SqlMapConfig.xml에서 설정 정보를 읽은 후 데베와의 연동 준비를 함
				Reader reader=Resources.getResourceAsReader(resource);
				sqlMapper=new SqlSessionFactoryBuilder().build(reader); //마이바티스를 이용하는 sqlMapper객체를 가져옴
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	public List<MemberVO> selectAllMemberList(){
		sqlMapper=getInstance(); 
		SqlSession session=sqlMapper.openSession(); //실제 member.xml의 sql문을 호출하는 데 사용되는 SqlSession 객체를 가져옴
		List<MemberVO> memlist=null;
		memlist=session.selectList("mapper.member.selectAllMemberList"); //여러개의 레코드를 조회하므로 selectList()메서드에 실행하고자 하는 sql문의 id를 인자로 전달
		return memlist;
	}
}
