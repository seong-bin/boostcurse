package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		// ApplicationContext : 인터페이스, ApplicationContext를 구현하는 다양한 컨태이너가 존재
		// ClassPathXmlApplicationContext : xml파일을 클래스패스에서 읽어들여서 사용하는 객체, bean으로 등록된것 다 메모리에 올림
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 완료!!!");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");// getBean의 인자로 userBean을 던지면 xml파일에서 id가 userBean인 애 찾아서 그 클래스 생성
		userBean.setName("Bea");
		
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스 입니다.");
		}
	}

}
