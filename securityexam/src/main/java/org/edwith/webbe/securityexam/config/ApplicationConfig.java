package org.edwith.webbe.securityexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 스프링 설정파일
//레이어드 아키텍처에서 Controller가 사용하는 Bean에 대해 설정을 한다.
//dao, service를 컴포넌트 스캔하여 찾도록 한다.
//어노테이션으로 트랜잭션을 관리하기 위해 @EnableTransactionManagement를 설정하였다.
@Configuration
@ComponentScan(basePackages = {"org.edwith.webbe.securityexam.dao", "org.edwith.webbe.securityexam.service"})
public class ApplicationConfig {

}
