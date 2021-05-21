package org.edwith.webbe.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// @Import : 설정 파일을 여러개로 나눠서 작성 가능
		//이 설정 파일 하나에 모든 설정을 다 넣지 않고  DB연결에 관련된 설정은 따로 빼서 설정 
// org.edwith.webbe.daoexam.dao에 @Repository이나 다른 어노테이션이 붙은 객체를 빈에 등록 해줌
@ComponentScan(basePackages = {"org.edwith.webbe.daoexam.dao"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
