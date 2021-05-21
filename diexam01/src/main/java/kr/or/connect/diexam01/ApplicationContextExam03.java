package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
//		Car car = (Car) ac.getBean("car");	// 아래처럼도 파라미터로 요청하는 class 타입으로 지정 가능
		Car car = (Car) ac.getBean(Car.class);	// Config파일 에서 리턴타입이 Car인 메소드를 찾음(메소드명과 달라도 무관)
		car.run();
	}

}
