package kr.co.connect.jdbcexam;

import kr.co.connect.jdbcexam.dto.Role;
import kr.co.connect.jdbcexam.dao.RoleDao;

public class JDBCExam1 {

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(1);
		System.out.println(role);
	}

}
