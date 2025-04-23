# Java Calculator

Java 문법을 활용하여 계산기를 만드는 프로젝트 입니다.  
단계별, 요구사항 별로 기능을 확장해 나아가며 기능 구현과 확장성 있는 구조로 작성된 계산기 입니다.  

---


---

## 1단계 계산기
### 요구사항
> - 양의 정수(0 포함)를 입력받기
> - 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
> - 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
> - 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을  입력하기 전까지 무한으로 계산을 진행  

### 사용법 & 실행결과

```bash
1번째 숫자 입력 : 1
2번째 숫자 입력 : 4
사칙연산 기호를 입력하세요(+, -, *, /): +
result = 5
더 계산하시겠습니까? (exit 입력 시 종료 / 아무거나 입력) : 
1번째 숫자 입력 : -2
양의정수(0포함)를 입력하세요
1번째 숫자 입력 : 3
2번째 숫자 입력 : 5
사칙연산 기호를 입력하세요(+, -, *, /): *
result = 15
더 계산하시겠습니까? (exit 입력 시 종료 / 아무거나 입력) : exit

종료 코드 0(으)로 완료된 프로세스
```

---

## 2단계 계산기
### 요구사항
> - 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
> - Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
> - App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
> - Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정

### 사용법 & 실행결과

```bash
1번째 숫자 입력 : 1
2번째 숫자 입력 : 2
사칙연산 기호를 입력하세요(+, -, *, /): +
result = 3
저장된 연산 값 = [3]
더 계산하시겠습니까? (exit 입력 시 종료 / 아무거나 입력 / del 입력시 데이터 삭제) : 
1번째 숫자 입력 : 3
2번째 숫자 입력 : /
양의정수(0포함)를 입력하세요
2번째 숫자 입력 : 3
사칙연산 기호를 입력하세요(+, -, *, /): /
result = 1
저장된 연산 값 = [3, 1]
더 계산하시겠습니까? (exit 입력 시 종료 / 아무거나 입력 / del 입력시 데이터 삭제) : del
저장된 연산 값 = [1]
```

---

## 3단계 계산기
### 요구사항
> - Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하기
> - 제네릭을 활용하여 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기
> - 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
### 구현 방법
#### Enum
```java
public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    symbol;
    //Enum 생성자
    OperatorType(char symbol) {...}
    //입력받은 symbol에 맞는 Enum 타입을 반환하는 메서드
    fromSymbol(char symbol){...}
```
#### 제네릭
```java
public class ArithmeticCalculator <T extends Number> {

    private List<T> results;

    ....
```
```java
ArithmeticCalculator<Double> doubleCalculator = new ArithmeticCalculator<>();

ArithmeticCalculator<Integer> integerCalculator = new ArithmeticCalculator<>();
```
### 사용법 & 실행결과
```bash
1번째 숫자 입력 : 1
2번째 숫자 입력 : 1
사칙연산 기호를 입력하세요(+, -, *, /): +
result = 2.0
※ 연산 수행 후 다음 동작을 선택하세요:
 - Enter 입력 → 연산 반복 진행
 - del 입력 → 컬렉션의 마지막 값 삭제
 - search 입력 → 입력한 값보다 큰 결과값 출력
 - exit 입력 → 프로그램 종료
입력: search
기준값 : 0
결과 = [2.0]
※ 연산 수행 후 다음 동작을 선택하세요:
 - Enter 입력 → 연산 반복 진행
 - del 입력 → 컬렉션의 마지막 값 삭제
 - search 입력 → 입력한 값보다 큰 결과값 출력
 - exit 입력 → 프로그램 종료
입력: exit
종료 코드 0(으)로 완료된 프로세스
```

---

## 프로젝트 구조

```
calculator
├── l1
│   └── App.java
├── v2
│   ├── App.java
│   └── Calculator.java
└── v3
    ├── App.java
    ├── ArithmeticCalculator.java
    └── OperatorType.java

```

---