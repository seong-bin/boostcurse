package org.edwith.webbe.securityexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 스피링 시큐리티 설정파일
// 스프링 시큐리티를 이용해 로그인/로그아웃/인증/인가 등을 처리하기 위한 설정 파일.
// @EnableWebSecurity가 붙어 있을 경우 스프링 시큐리티를 구성하는 기본적인 빈(Bean)들을 자동으로 구성.
// WebSecurityConfigurerAdapter를 상속받으면, 특정 메소드를 오버라이딩 함으로써 좀 더 손쉽게 설정할 수 있다
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //   /webjars/** 경로에 대한 요청은 인증/인가 처리하지 않도록 무시한다.
	// 인증/인가가 필요 없는 경로를 설정할 필요가 있을 때 오버라이딩
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(
//                "/webjars/**");
//    }

    // 인증/인가에 대한 설정
	//   /, /main에 대한 요청은 누구나 할 수 있지만, 
    //   그 외의 요청은 모두 인증 후 접근 가능
    // - configure(WebSecurity web) 가 더 우선
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/main","/","/test").permitAll()	// /, /main에 대한 요청은 누구나
                .anyRequest().authenticated();	// 그 외에는 인증 후에 접근
//                .antMatchers("/**").authenticated();	// 그 외에는 인증 후에 접근
    }

    // 패스워드 인코더를 빈으로 등록. 암호를 인코딩하거나, 
    // 인코딩된 암호와 사용자가 입력한 암호가 같은 지 확인할 때 사용.
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
