package org.edwith.webbe.daoexam.main;

import org.edwith.webbe.daoexam.config.ApplicationConfig;
import org.edwith.webbe.daoexam.dao.RoleDao;
import org.edwith.webbe.daoexam.dto.RoleDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class jdbcTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		RoleDTO role = new RoleDTO();
		role.setRoleId(100);
		role.setDescription("AMO2");
		
//		int cnt = roleDao.insert(role);
//		System.out.println(cnt+"건 입력 ");
//		int cnt = roleDao.update(role);
//		System.out.println(cnt+"건 수정 ");

//		int cnt = roleDao.delete(role);
//		System.out.println(cnt+"건 삭제 ");
		
		RoleDTO byIdResult = roleDao.selectById(100);
		System.out.println(byIdResult);
	}

}
