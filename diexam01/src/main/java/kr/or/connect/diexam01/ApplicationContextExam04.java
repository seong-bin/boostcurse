package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam04 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		Car car = (Car) ac.getBean(Car.class);	// Config파일 에서 리턴타입이 Car인 메소드를 찾음(메소드명과 달라도 무관)
		car.run();
	}

}
