package kr.co.connect.jdbcexam;

import kr.co.connect.jdbcexam.dao.RoleDao;
import kr.co.connect.jdbcexam.dto.Role;

public class JDBCExam2 {

	public static void main(String[] args) {
		int role_id = 2;
		String description = "CEO";
		
		Role role = new Role(role_id, description);
		
		RoleDao dao = new RoleDao();
		
//		int insertCnt = dao.addRole(role);
//		System.out.println("입력된 건수 = "+insertCnt);
		int updateCnt = dao.updateRole(role);
		System.out.println("수정된 건수 = "+updateCnt);

	}

}
