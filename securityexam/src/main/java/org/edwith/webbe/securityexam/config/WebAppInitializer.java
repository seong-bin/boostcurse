package org.edwith.webbe.securityexam.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml파일을 대신하는 자바 Config설정파일
//WebAppInitializer 클래스가 web.xml을 대신한다
//스프링 mvc에서는 AbstractAnnotationConfigDispatcherServletInitializer를 상속받아 구현하는게 조금 더 편리
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// Spring Config 파일을 리턴하는 메소드
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class, SecurityConfig.class};
    }

    // Spring MVC Config 파일을 리턴하는 메소드
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

	// getServletMapping()은 DispatcherServlet이 매핑되기 위한 하나 혹은 여러 개의 패스를 지정한다.
	// DispatcherServlet이 처리해야할 path가 무엇인지 스프링 컨테이너에게 알림
    // "/"는 모든 경로를 처리할 때 사용하는 path값
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // DispatcherServlet 앞에 동작하는 필터를 설정
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");

        return new Filter[]{encodingFilter};
    }
}
