package v3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /*스캐너 객체 선언*/
        Scanner scanner = new Scanner(System.in);
        /*계산기 객체 선언*/
        ArithmeticCalculator<Double> doubleCalculator = new ArithmeticCalculator<>();

        /* 프로그램 종료 변수 */
        boolean exitFlag = false;

        /*무한 반복*/
        while (!exitFlag) {
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

            /**
             * 연산 수행후 상태 선택
             * Enter 입력 -> 반복 진행
             * del 입력 -> 컬렉션의 마지막 값 삭제
             * search 입력 -> Scanner로 입력받은 값보다 큰 결과값 출력
             * exit 입력 -> 종료
             */
            while(true){
                System.out.println("※ 연산 수행 후 다음 동작을 선택하세요:");
                System.out.println(" - Enter 입력 → 연산 반복 진행");
                System.out.println(" - del 입력 → 컬렉션의 마지막 값 삭제");
                System.out.println(" - search 입력 → 입력한 값보다 큰 결과값 출력");
                System.out.println(" - exit 입력 → 프로그램 종료");
                System.out.print("입력: ");

                String input = scanner.nextLine();

                if(input.equals("exit")) {
                    exitFlag = true;
                    break;
                }

                if(input.equals("search")) {
                    System.out.print("기준값 : ");
                    Double num1 = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("결과 = " + doubleCalculator.searchResults(num1));
                    continue;
                }

                /*입력이 del이면 데이터 삭제 */
                if (input.equals("del")) {
                    doubleCalculator.deleteResult(0);
                }

                if (input.equals("")) {
                    break;
                }
                else{
                    System.out.println("4개중 하나만 입력하세요");
                }
            }
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
