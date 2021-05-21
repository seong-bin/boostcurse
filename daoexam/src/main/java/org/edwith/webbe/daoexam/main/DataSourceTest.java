package org.edwith.webbe.daoexam.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.edwith.webbe.daoexam.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DataSourceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class);
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null) {
				System.out.println("접속 성공");
			}
		}catch (Exception e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
