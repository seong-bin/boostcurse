package kr.or.connect.guestbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
/// 트랜잭션 관련 설정 자동으로 해주는 어노테이션. 
// 단, 사용자간의 트랜잭션 처리를 위한 플랫폼트랜잭션매니저를 설정하기 위해서는
// TransactionManagementConfigurer를 구현하고 annotationDrivenTransactionManager()메소드를 오버라이딩 해야 함
// 그 메소드에서 트랜잭션을 처리할 PlatformTransactionManager객체를 반환하면 됨
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
	private String driverClassName = "com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/boostcourse?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private String username = "root";
	private String password = "tlwkr19";

	@Bean
	public DataSource dataSource() {
		System.out.println("db 정보");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		System.out.println("annotationDrivenTransactionManager 111");
		return transactionManger();
	}

	@Bean
	public PlatformTransactionManager transactionManger() {
		System.out.println("transactionManger 222");
		return new DataSourceTransactionManager(dataSource());
	}
}
