package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/pro07");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean overlappedID(String id)
	{
		boolean result=false;
		try {
			con = dataFactory.getConnection();
			String query = "select case count(*) when 1 then 'true' else 'false' end as result from t_member"; //오라클 decode()함수를 이용해 존재하면 true
			query += " where id=?";
			System.out.println("prepareStaememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result")); //문자열을 boolean자료형으로 변환
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
