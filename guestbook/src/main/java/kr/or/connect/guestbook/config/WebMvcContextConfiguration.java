package kr.or.connect.guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration	// 설정파일 명시
@EnableWebMvc	// 기본적인 설정 자동으로 해줌
@ComponentScan(basePackages = { "kr.or.connect.guestbook.controller" })	// 해당 패키지의 controller 알아서 읽어옴
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {	// WebMvcConfigurerAdapter를 상속 받는다
	// url 요청이 아래처럼 들어오면 해당 폴더에서 읽기
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
	
	// default servlet handler를 사용하게 함.
	// 매핑정보가 없는 url요청이 들어 왔을 때 spring의 DefaultServletHttpRequestHandler가 처리하도록 해줌
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    // 특정 url에 대한 처리를 controller에서 처리하지 않고 매핑할 수 있도록 해주는 메소드
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    	System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("index");
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
