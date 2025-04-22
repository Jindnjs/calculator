package v3;

import java.util.Arrays;

public enum OperatorType {

    /* 각 연산자별 Enum과 symbol(사용자 입력 연산기호) , 람다식 */
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    /* Enum과 사용자 입력 연산자를 매핑하기 위한 심볼 */
    private final char symbol;

    /* Enum 생성자 */
    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    /* 입력받은 symbol에 맞는 Enum 타입을 반환하는 메서드 */
    public static OperatorType fromSymbol(char symbol) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.symbol == symbol)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("잘못된 연산자 입니다. 다시 입력하세요."));
    }
}
