package v1;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {

        /*스캐너 객체 선언*/
        Scanner scanner = new Scanner(System.in);

        /*첫번째 숫자 입력*/
        int firstNum = inputInt(1, scanner);
        /*두번쨰 숫자 입력*/
        int secondNum = inputInt(2, scanner);

        /*연산기호 검사에 쓰일 배열*/
        char [] operators = {'+', '-', '*', '/'};
        char operator;
        /*연산 기호 입력*/
        /*연산기호가 + - * / 가 아니면 다시 입력받기*/
        while(true) {
            /*while 탈출 변수*/
            boolean flag = false;

            /*연산자 입력*/
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            operator = scanner.next().charAt(0);
            for (char a : operators) {
                if (operator == a) {
                    flag = true;
                    break;
                }
            }
            if (flag) {break;}
            System.out.println("(+, -, *, /)만 입력하세요.");
        }

        /*연산 수행 및 출력*/
        switch(operator) {
            case '+':
                System.out.println("result = " + (firstNum + secondNum));
                break;
            case '-':
                System.out.println("result = " + (firstNum - secondNum));
                break;
            case '*':
                System.out.println("result = " + (firstNum * secondNum));
                break;
            case '/':
                try {
                    System.out.println("result = " + (firstNum / secondNum));
                }catch (ArithmeticException e) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                break;
        }
    }

    /*
     * 숫자를 입력받고, 타입을 검사하는 메서드
     * 음수면 continue로 무한루프
     * 양수면 입력숫자 리턴
     */
    public static int inputInt(int sequence, Scanner scanner) {
        while (true) {
            System.out.print(sequence + "번째 숫자 입력 : ");
            int inputNum = scanner.nextInt();
            if (inputNum < 0) {
                System.out.println("양의정수(0포함)를 입력하세요");
                continue;
            }
            return inputNum;
        }
    }
}
