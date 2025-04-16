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
