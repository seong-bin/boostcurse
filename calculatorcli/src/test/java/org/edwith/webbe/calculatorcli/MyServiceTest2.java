package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

// mockito가 제공하는 Junit 확장 클래스 MockitoJunitRunner를 이용해 테스트 클래스를 실행하도록 합니다.
@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest2 {
	// @InjectMocks 어노테이션이 붙은 필드는 목 객체를 사용하는 MyService 객체를 생성하여 초기화하라는 의미
	// myService 역시 여러분들이 초기화하지 않아도 자동으로 MyService 객체가 생성되어 초기화
    @InjectMocks
    MyService myService;

    //@Mock 어노테이션은 calculatorService가 목 객체를 참조하도록 합니다.
    //즉, 여러분이 객체를 생성하지 않아도 자동으로 객체가 생성되고 해당 필드가 초기화 된다는 것을 의미
    @Mock
    CalculatorService calculatorService;

    @Test
    public void execute() throws Exception{
        // given
        int value1 = 5;
        int value2 = 10;
        // given() : static메소드
        //import문을 보면 org.mockito.BDDMockito 클래스의 static 메소드인것을 알 수 있습니다. 
        //calculatorService는 가짜 객체입니다. 이 가짜 객체가 동작하는 방법을 규정할 수 있는 것이 given()메소드입니다.
        //calculatorService.plus(5,10)을 호출하면 plus메소드가 15를 반환하도록 하라는 의미를 가집니다. 
        given(calculatorService.plus(5, 10)).willReturn(15);
        //when

        // when
        // execute()메소드는 내부적으로 calculatorService의 plus메소드를 호출
        int result = myService.execute(value1, value2);

        // then
        verify(calculatorService).plus(anyInt(), anyInt());
        Assert.assertEquals(30, result);
    }
}