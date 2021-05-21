package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @RunWith : JUnit은 확장기능을 가지는데, 스프링에서는 JUnit을 확장하도록 SpringJUnit4ClassRunner.class를 제공
//			JUnit이 테스트 코드를 실행할 때 스프링 빈 컨테이너가 내부적으로 생성되도록 함
@RunWith(SpringJUnit4ClassRunner.class)	
// 내부적으로 생성된 스프링 빈 컨테이너가 사용할 설정파일을 지정할 때 사용
@ContextConfiguration(classes = {ApplicationConfig.class})
// 위에서 설명한 2줄이 테스트 클래스 위에 있으면, 테스트 클래스 자체가 빈(Bean)객체가 되어 스프링에서 관리됨
public class CalculatorServiceTest {
//	CalcultorServiceTest 클래스가 빈으로 관리되면서, 스프링 빈 컨테이너는 CalculatorService를
//	주입(Inject)할 수 있게 됨. 이렇게 주입된 클래스를 테스트하면 됨.
    @Autowired
    CalculatorService calculatorService;

    @Test
    public void plus() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.plus(value1, value2);

        // then
        Assert.assertEquals(result, 15); // 결과와 15가 같을 경우에만 성공
    }

    @Test
    public void divide() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.divide(value1, value2);

        // then
        Assert.assertEquals(result, 2); // 결과와 2가 같을 경우에만 성공
    }

    @Test
    public void divideExceptionTest() throws Exception{
        // given
        int value1 = 10;
        int value2 = 0;

        try {
            calculatorService.divide(value1, value2);
        }catch (ArithmeticException ae){
            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
            return; // 메소드를 더이상 실행하지 않는다.
        }
        
        Assert.assertTrue(false); // 이부분이 실행되면 무조건 실패다.
    }
}
// * Junit 강의
//public class CalculatorServiceTest {
//	CalculatorService calculatorService;
//
////	테스트 클래스에 테스트 메소드가 3개 있다면, 각각의 메소드에는 @Test가 붙어 있어야 합니다.
////	테스트 클래스가 실행되기 전에 @BeforeClass가 붙은 메소드가 실행됩니다.
////	그리고 테스트 메소드가 실행되기 전에 @Before가 붙은 메소드가 실행됩니다.
////	그다음은 @Test가 붙은 메소드가 실행되고 @After가 붙은 메소드가 실행됩니다.
////	이렇게 3개의 메소드가 실행된 후에 @AfterClass가 붙은 메소드가 실행되고 프로그램은 종료됩니다.
//	
//	// @BeforeClass : 테스트 클래스가 실행되기 전에 딱 한번 실행
//	// @AfterClass : 테스트 클래스의 모든 테스트 메소드가 실행이 끝나고 딱 한번 실행
//	// @Before : 테스트 메소드가 실행되기 전에 실행. 테스트 메소드가 5개 있는 테스트 클래스를 실행하면 @Before가 붙은 메소드는 5번 실행
//	// @After : 테스트 메소드가 실행된 후 실행. 테스트 메소드가 5개 있는 테스트 클래스를 실행하면 @After가 붙은 메소드는 5번 실행
//    @Before
//    public void init(){
//        this.calculatorService = new CalculatorService();
//    }
//
//    // 테스트메소드
//    @Test
//    public void plus() throws Exception{
//        // given
//        int value1 = 10;
//        int value2 = 5;
//
//        // when
//        int result = calculatorService.plus(value1, value2);
//
//        // then
//        Assert.assertEquals(15, result); // 결과와 15가 같을 경우에만 성공
//    }
//
//    // 테스트메소드
//    @Test
//    public void divide() throws Exception{
//        // given
//        int value1 = 10;
//        int value2 = 5;
//
//        // when
//        int result = calculatorService. divide (value1, value2);
//
//        // then
//        Assert.assertEquals(2,result); // 결과와 2가 같을 경우에만 성공
//    }
//
//    // 테스트메소드
//    @Test
//    public void divideExceptionTest() throws Exception{
//        // given
//        int value1 = 10;
//        int value2 = 0;
//        double result;
//        try {
//            result = calculatorService.divide(value1, value2);
//            System.out.println(result);
//        }catch (ArithmeticException ae){
//            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
//            return; // 메소드를 더이상 실행하지 않는다.
//        }
//        Assert.fail("실패"); // 이부분이 실행되면 무조건 실패다.
//    }
//}
