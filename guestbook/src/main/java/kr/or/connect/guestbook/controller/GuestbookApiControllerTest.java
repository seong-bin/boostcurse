package kr.or.connect.guestbook.controller;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.config.WebMvcContextConfiguration;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcContextConfiguration.class, ApplicationConfig.class })
public class GuestbookApiControllerTest {

//	@InjectMocks어노테이션이 붙여서 선언된 guestbookApiController는 목객체인 GuestbookService를 사용하게 됩니다.
//	스프링에 위해 주입된 객체를 사용하는 것이 아닌 Mockito 프레임워크에 위해 생성된 목객체가 주입되어 객체가 생성
	@InjectMocks
    public GuestbookApiController guestbookApiController;

	// @Mock어노테이션을 붙여서 선언된 guestbookService는 mockito에 위해 목객체로 생성(가짜 객체)
    @Mock
    GuestbookService guestbookService;

    private MockMvc mockMvc;

    @Before
    public void createController() {
    	// 현재 객체에서 @Mock이 붙은 필드를 목객체로 초기화
        MockitoAnnotations.initMocks(this);
        // guestbookApiController를 테스트 하기 위한 MockMvc객체를 생성
        mockMvc = MockMvcBuilders.standaloneSetup(guestbookApiController).build();
    }

    @Test
    public void getGuestbooks() throws Exception {
        Guestbook guestbook1 = new Guestbook();
        guestbook1.setId(1L);
        guestbook1.setRegdate(new Date());
        guestbook1.setContent("hello");
        guestbook1.setName("bae");

        List<Guestbook> list = Arrays.asList(guestbook1);
        // when( 목객체.목객체메소드호출() ).threnReturn(목객체 메소드가 리턴 할 값)
        when(guestbookService.getGuestbooks(0)).thenReturn(list);

        // MockMvcRequestBuilders를 이용해 MockMvc에게 호출할 URL을 생성(GET 방식으로 /guestbooks 경로를 호출하라는 의미)
        // contentType(MediaType.APPLICATION_JSON) : application/json 형식으로 api를 호출
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/guestbooks").contentType(MediaType.APPLICATION_JSON);
        // mockMvc.perform(reqBuilder) : reqBuilder에 해당하는 URL에 대한 요청을 보냈다는 것을 의미
        // andExpect(status().isOk()) : mockMvc에 위해 URL이 실행되고 상태코드값이 200이 나와야 한다는 것을 의미
        // andDo(print()) : 처리 내용을 출력
        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
        // Json 결과에 “name”:”kim”이 있을 경우에만 성공
//        mockMvc.perform(reqBuilder).andExpect(jsonPath("$.list[0].name").value("bae")); 

        verify(guestbookService).getGuestbooks(0);
    }

    // 방명록을 삭제하는 web api를 테스트
//    @Test
//    public void deleteGuestbook() throws Exception {
//        Long id = 1L;
//
//        when(guestbookService.deleteGuestbook(id, "127.0.0.1")).thenReturn(1);
//
//        // “/guestbooks/” + id 경로를 DELETE방식으로 호출하기 위한 경로 정보를 가지고 있는 reqBuilder객체를 생성
//        RequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/guestbooks/" + id).contentType(MediaType.APPLICATION_JSON);
//        // reqBuilder에 해당하는 URL을 호출한 후, 상태 코드가 200일 경우 성공합니다. 그리고 결과를 출력
//        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
//
//        // guestbookService 목객체의 deleteGuestbook(id, “127.0.0.1”)메소드가 Web API가 동작하면서 호출되었다면 성공
//        verify(guestbookService).deleteGuestbook(id, "127.0.0.1");
//    }
}
