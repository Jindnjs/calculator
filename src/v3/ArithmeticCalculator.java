package v3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T extends Number> {

    /* 연산 결과를 저장하는 컬렉션*/
    /* 요구사항에 맞게 캡슐화*/
    private List<T> results;

    public ArithmeticCalculator() {
        results = new ArrayList<>();
    }

    /**
     * 사칙연산 수행후, 결과값을 반환하는 메서드
     * Enum 사용하여 결과 반환하도록 변경
     */
    public T calculate(T firstNum, T secondNum, OperatorType operator) {

        /* 계산 수행시, 더블형으로 계산 진행 */
        double one = firstNum.doubleValue();
        double two = secondNum.doubleValue();
        double result = 0;

        switch (operator) {
            case PLUS:
                result = one + two;
                break;
            case MINUS:
                result = one - two;
                break;
            case MULTIPLY:
                result = one * two;
                break;
            case DIVIDE:
                if(two == 0)
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                result = one / two;
                break;
        }

        /* 결과를 T 타입으로 변환 */
        if (firstNum instanceof Integer) {
            return (T) Integer.valueOf((int) result);
        } else if (firstNum instanceof Long) {
            return (T) Long.valueOf((long) result);
        } else if (firstNum instanceof Float) {
            return (T) Float.valueOf((float) result);
        } else if (firstNum instanceof Double) {
            return (T) Double.valueOf(result);
        } else {
            throw new UnsupportedOperationException("지원하지 않는 숫자 타입: " + firstNum.getClass());
        }
    }

    /* Getter / Setter */
    public List<T> getResults() {return results;}
    public void addResult(T result) {this.results.add(result);}

    /* 컬렉션의 i번째 데이터 삭제하는 메서드*/
    public void deleteResult(int idx) {
        this.results.remove(idx);
        System.out.println("저장된 연산 값 = " + results);
    }
}
