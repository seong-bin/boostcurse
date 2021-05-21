package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
//------------------------------------
//@Configuration
//스프링 설정 클래스를 선언하는 어노테이션

//@Bean
//bean을 정의하는 어노테이션

//@ComponentScan
//@Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록

//@Component
//컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션

//@Autowired
//주입 대상이되는 bean을 컨테이너에 찾아 주입하는 어노테이션
//------------------------------------
import org.springframework.context.annotation.Configuration;
// 어노테이션 jdk 5부터
// 스프링 설정 클래스라는 의미
@Configuration
public class ApplicationConfig {
	// bean등록을 위한 어노테이션, 싱글톤으로 관리 @Bean어노테이션 붙이고 메소드처럼 생성
	@Bean
	public Car car (Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine () {
		return new Engine();
	}
}
