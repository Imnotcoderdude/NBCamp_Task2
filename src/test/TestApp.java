package test;
// 1:26:58 까지 듣고 만든것
// 아직 결과는 출력되지 않음
import main.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TestCalculator calculator = new TestCalculator(new ArrayList<>(), new ArrayList<>());


        do {

            System.out.println("어떤 계산? 1.사칙연산 2.원의넓이");
            int choice = sc.nextInt();

            if (choice == 1) {


                System.out.print("첫 번째 숫자를 입력하세요 : ");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                int num2 = sc.nextInt();
                System.out.print("연산기호를 입력하세요 : ");
                char oper = sc.next().charAt(0);

                int result = calculator.calculate(num1, num2, oper);
                calculator.getResults().add(result);


                System.out.println("배열에 저장된 0번째 인덱스를 삭제하시겠습니까? (remove)");
                if (Objects.equals(sc.next(), "remove")) {
                    calculator.removeResult(0);
                }
                System.out.println("저장된 연산 결과 조회 (inquiry)");
                if (Objects.equals(sc.next(), "inquiry")) {
                    calculator.inquiryResults();
                }
            }else {
                System.out.println("원의 반지름 : ");
                int radius = sc.nextInt();

                double area = calculator.calculateCircleArea(radius);
                calculator.getCirculeresult().add(area);
                System.out.println("반지름이 " + radius + "인 원의 넓이는 : " + area);

                System.out.println("저장된 원의 넓이 전체 조회");
                calculator.inquiryCircleresult();
            }
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료) ");
        } while (!sc.next().equals("exit"));
    }
}

