package v2;

import java.util.ArrayList;

public class Calculator {

    /* 연산 결과를 저장하는 컬렉션*/
    /* 요구사항에 맞게 캡슐화*/
    private ArrayList<Integer> results;

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
                return firstNum / secondNum;
        }
        throw new IllegalArgumentException("잘못된 연산자.");

    }

    /* Getter / Setter */
    public ArrayList<Integer> getResults() {return results;}
    public void addResult(int result) {this.results.add(result);}

    /* 컬렉션의 i번째 데이터 삭제하는 메서드*/
    public void deleteResult(int idx) {
        this.results.remove(idx);
        System.out.println("저장된 연산 값 = " + results);
    }
}
