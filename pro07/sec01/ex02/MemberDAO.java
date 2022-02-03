package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class MemberDAO {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/pro07";
	private static final String user = "root";
	private static final String pwd = "rlaalsrud11@";
	private Connection con;
	private PreparedStatement pstmt;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB(); //네 가지 정보로 데이터베이스 연결
			String query = "select * from t_member ";
			System.out.println("PreparedStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query); //결과값 담기
			
			while(rs.next()) { //조회한 레코드의 각 컬럼 값을 받아옴
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO(); //각 컬럼 값을 다시 membervo()객체의 속성에 설정
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo); //설절된 MemberVO() 객체를 다시 arrayList에저장
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("MySQL 드라이버 로딩 성공");
			
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
