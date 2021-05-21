package kr.co.connect.jdbcexam.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.connect.jdbcexam.dto.Role;

public class RoleDao {
//	private static String dbUrl = "jdbc:mysql://localhost:3306/boostcourse?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUrl = "jdbc:mysql://localhost:3306/boostcourse";
	private static String dbUser = "root";
	private static String dbPassword= "tlwkr19";
	
	// 모든 데이터 조회하는 메소드
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM role order by role_id desc";
		
		//트라이위드리소스 이용하여 괄호 안에 있는객체들 알아서 close 해 줌
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
//	public List<Role> getRoles() {
//		List<Role> list = new ArrayList<>();
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		String sql = "SELECT description, role_id FROM role order by role_id desc";
//		try {
//			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			try (ResultSet rs = ps.executeQuery()) {
//
//				while (rs.next()) {
//					String description = rs.getString(1);
//					int id = rs.getInt("role_id");
//					Role role = new Role(id, description);
//					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return list;
//	}
	
	// 한건 업데이트 하는 메소드
	public int updateRole(Role role) {
		int updateCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			
			String sql = "UPDATE role SET description = ? WHERE role_id = ?";
			
			ps = conn.prepareStatement(sql);

			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRole_id());

			// insert, update, delete 쿼리는 executeUpdate() 사용, 실행된 건수 int값 반환
			updateCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}
	// 한건 입력하는 메소드
	public int addRole(Role role) {
		int insertCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			
			String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";
			
			ps = conn.prepareStatement(sql);

			ps.setInt(1, role.getRole_id());
			ps.setString(2, role.getDescription());

			// insert, update, delete 쿼리는 executeUpdate() 사용, 실행된 건수 int값 반환
			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return insertCount;
	}
	
	// 한건 조회하는 메소드
	public Role getRole(int role_id) {		
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 연결하는 부분
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			
			// 실행하는 부분
			String sql = "SELECT description, role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role_id);

			// 받아오는 부분
			rs = ps.executeQuery();
			if(rs.next()) {
				String description = rs.getString("description");	//컬럼명 써도 되고
				int id = rs.getInt(2);					//인덱스 써도 됨 (1부터 시작)
				role = new Role(id, description);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return role;
	}
}
