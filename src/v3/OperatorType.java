package v3;

import java.util.Arrays;

public enum OperatorType {

    /* 각 연산자별 Enum과 symbol(사용자 입력 연산기호) , 람다식 */
    PLUS('+', (a,b) -> a + b),
    MINUS('-', (a,b) -> a - b),
    MULTIPLY('*', (a,b) -> a * b),
    DIVIDE('/', (a,b) -> {
        if(b==0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        return a / b;
    });

    /* Enum과 사용자 입력 연산자를 매핑하기 위한 심볼 */
    private final char symbol;
    /* Enum의 해당 연산자에 대응되는 연산 수행 메서드 */
    private final Operate operate;

    /* 연산하는 메서드 매핑 */
    public int caculate(int a, int b){
        return this.operate.operate(a,b);
    }

    /* Enum 생성자 */
    OperatorType(char symbol, Operate operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    /* 계산을 위한 함수형 인터페이스 정의 */
    @FunctionalInterface
    private interface Operate{
        int operate(int a, int b);
    }

    /* 입력받은 symbol에 맞는 Enum 타입을 반환하는 메서드 */
    public static OperatorType fromSymbol(char symbol) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.symbol == symbol)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("잘못된 연산자."));
    }
}
