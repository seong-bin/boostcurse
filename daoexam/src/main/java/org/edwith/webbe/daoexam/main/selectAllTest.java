package org.edwith.webbe.daoexam.main;

import java.util.List;

import org.edwith.webbe.daoexam.config.ApplicationConfig;
import org.edwith.webbe.daoexam.dao.RoleDao;
import org.edwith.webbe.daoexam.dto.RoleDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class selectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		List<RoleDTO> list = roleDao.selectAll();
		
		for(RoleDTO l : list) {
			System.out.println(l);
		}

	}

}
