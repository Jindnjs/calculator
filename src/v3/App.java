package v3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /*스캐너 객체 선언*/
        Scanner scanner = new Scanner(System.in);
        /*계산기 객체 선언*/
        ArithmeticCalculator<Double> doubleCalculator = new ArithmeticCalculator<>();

        /*무한 반복*/
        while (true) {
            /*첫번째 숫자 입력*/
            double firstNum = inputNum(1, scanner, Double.class);
            /*두번쨰 숫자 입력*/
            double secondNum = inputNum(2, scanner, Double.class);

            /*연산기호 검사를 Enum에 위임*/
            while (true) {
                /*연산자 사용자 입력*/
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
                char operatorInput = scanner.next().charAt(0);
                /*버퍼 비우기*/
                scanner.nextLine();

                try{
                    /* 사용자 입력 연산자로 Enum타입 가져오기*/
                    OperatorType operatorType = OperatorType.fromSymbol(operatorInput);
                    /*연산 수행 및 출력*/
                    double result = doubleCalculator.calculate(firstNum, secondNum, operatorType);
                    System.out.println("result = " + result);
                    /*연산결과를 컬렉션에 저장*/
                    doubleCalculator.addResult(result);
                    break;
                }//연산자가 + - * / 이외인 경우
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }//0으로 나눈 경우
                catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    break;
                }
                catch (Exception e) {
                    System.out.println("알 수 없는 오류" + e.getMessage());
                    break;
                }
            }
            /* 저장된 연산 결과 출력 */
            System.out.println("저장된 연산 값 = " + doubleCalculator.getResults());

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료 / 아무거나 입력 / del 입력시 데이터 삭제) : ");
            String input = scanner.nextLine();

            /*입력이 del이면 데이터 삭제 */
            if (input.equals("del")) {
                doubleCalculator.deleteResult(0);
            }

            /*입력이 exit이면 while 무한반복문 탈출*/
            if (input.equals("exit")) {
                break;
            }
            /* 다시 반복 */
        }
        scanner.close();
    }

    /*
     * 숫자를 입력받고, 타입을 검사하는 메서드
     * 음수면 continue로 무한루프
     * 양수면 입력숫자 리턴
     *
     * 제네릭 적용, Class type에 맞는 타입으로 캐스팅하여 리턴
     */
    public static <T extends Number> T inputNum(int sequence, Scanner scanner, Class<T> type) {
        while (true) {
            System.out.print(sequence + "번째 숫자 입력 : ");
            String inputValue = scanner.nextLine();

            try {
                Number parsedNumber;

                if (type == Integer.class) {
                    parsedNumber = Integer.parseInt(inputValue);
                    if (parsedNumber.intValue() < 0)
                        throw new IllegalArgumentException();
                } else if (type == Double.class) {
                    parsedNumber = Double.parseDouble(inputValue);
                    if (parsedNumber.doubleValue() < 0)
                        throw new IllegalArgumentException();
                } else if (type == Long.class) {
                    parsedNumber = Long.parseLong(inputValue);
                    if (parsedNumber.longValue() < 0)
                        throw new IllegalArgumentException();
                } else if (type == Float.class) {
                    parsedNumber = Float.parseFloat(inputValue);
                    if (parsedNumber.floatValue() < 0)
                        throw new IllegalArgumentException();
                } else {
                    throw new UnsupportedOperationException("지원하지 않는 타입입니다: " + type.getSimpleName());
                }

                return type.cast(parsedNumber);
            } catch (Exception e) {
                System.out.println("유효한 양의 숫자를 입력하세요 (" + type.getSimpleName() + ")");
            }
        }
    }
}
