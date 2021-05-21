package kr.or.connect.diexam01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 패키지 안에 있는 파일들 (@Controller, @Service, @Component @레파지토리 등) 읽어 메모리에 올리고 DI주입
@ComponentScan("kr.or.connect.diexam01")
public class ApplicationConfig2 {

}
