package org.edwith.webbe.calculatorcli;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//스프링 설정 파일은 스프링 빈 컨테이너인 ApplicationContext에서 읽어 들인다
@Configuration
// 어노테이션에 설정된 패키지 이하로부터 @Component, @Repository, @Service, @Controller, @RestController 등의 어노테이션이 붙은 클래스를 찾아 빈으로 등록
@ComponentScan(basePackages = {"org.edwith.webbe.calculatorcli"})
public class ApplicationConfig {

}
