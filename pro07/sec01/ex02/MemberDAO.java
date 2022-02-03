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
			connDB(); //�� ���� ������ �����ͺ��̽� ����
			String query = "select * from t_member ";
			System.out.println("PreparedStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query); //����� ���
			
			while(rs.next()) { //��ȸ�� ���ڵ��� �� �÷� ���� �޾ƿ�
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO(); //�� �÷� ���� �ٽ� membervo()��ü�� �Ӽ��� ����
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo); //������ MemberVO() ��ü�� �ٽ� arrayList������
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
			System.out.println("MySQL ����̹� �ε� ����");
			
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
