package v2;

import java.util.ArrayList;

public class Calculator {

    /* 연산 결과를 저장하는 컬렉션*/
    public ArrayList<Integer> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    /*사칙연산 수행후, 결과값을 반환하는 메서드*/
    public int calculate(int firstNum, int secondNum, char operator) {
        switch (operator) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                if(secondNum == 0)
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
        throw new IllegalArgumentException("잘못된 연산자.");

    }
}
