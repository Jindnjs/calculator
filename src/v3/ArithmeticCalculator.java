package v3;

import java.util.ArrayList;

public class ArithmeticCalculator {

    /* 연산 결과를 저장하는 컬렉션*/
    /* 요구사항에 맞게 캡슐화*/
    private ArrayList<Integer> results;

    public ArithmeticCalculator() {
        results = new ArrayList<>();
    }

    /**
     * 사칙연산 수행후, 결과값을 반환하는 메서드
     * Enum 사용하여 결과 반환하도록 변경
     */
    public int calculate(int firstNum, int secondNum, char operator) {
        return OperatorType.fromSymbol(operator).caculate(firstNum, secondNum);
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
