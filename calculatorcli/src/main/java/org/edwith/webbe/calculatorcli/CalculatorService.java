package org.edwith.webbe.calculatorcli;

import org.springframework.stereotype.Component;

// 스프링 빈 컨테이너가 CalculatorService클래스를 찾아 빈으로 등록할 수 있도록 클래스 위에 @Component를 붙인다
@Component
public class CalculatorService {
	public int plus(int value1, int value2) {
        return value1 + value2;
    }

    public int minus(int value1, int value2) {
        return value1 - value2;
    }

    public int multiple(int value1, int value2) {
        return value1 * value2;
    }

    public int divide(int value1, int value2) throws ArithmeticException {
        return value1 / value2;
    }
}
