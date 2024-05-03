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
        // 사용자로부터 값을 입력받기 위해 Scanner 사용
        Scanner sc = new Scanner(System.in);
        // TestCalculator의 객체를 생성. 계산해야하는 것이 사칙연산과 원의 넓이 두가지 이므로 배열 두개 설정
        TestCalculator calculator = new TestCalculator(new ArrayList<>(), new ArrayList<>());

        // do - while 반복문을 사용하여 계산의 반복을 생성
        do {
            System.out.println("어떤 계산? 1.사칙연산 2.원의넓이");
            // choice로 숫자를 입력받아서 사칙연산, 원의넓이 둘중 하나 선택
            int choice = sc.nextInt();
            // choice로 받은 숫자가 1일 경우 사칙연산 수행
            if (choice == 1) {
                // 정수와 연산기호를 입력받는 부분
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                int num2 = sc.nextInt();
                System.out.print("연산기호를 입력하세요 : ");
                char oper = sc.next().charAt(0);
                // 입력받은 값을 객체에서 연산하고 결과를 가져오는 부분.
                int result = calculator.calculate(num1, num2, oper);
                // 연산된 결과를 배열 안에 저장하는 부분.
                calculator.getResults().add(result);

                // 인덱스 삭제 로직
                System.out.println("배열에 저장된 0번째 인덱스를 삭제하시겠습니까? (remove)");
                // sc.next로 입력받은 값이 remove일 경우 실행, remve 말고 다른 값 입력시 아래로 넘어감
                if (Objects.equals(sc.next(), "remove")) {
                    // 계산기 내부에 0번째 인덱스를 삭제한다.
                    calculator.removeResult(0);
                }
                // inquiry를 입력받을시 작동, 저장된 모든 결과를 출력한다.
                System.out.println("저장된 연산 결과 조회 (inquiry)");
                if (Objects.equals(sc.next(), "inquiry")) {
                    calculator.inquiryResults();
                }
            }else {
                // 원의 넓이를 계산하고 출력하는 부분.
                System.out.println("원의 반지름 : ");
                int radius = sc.nextInt();

                double area = calculator.calculateCircleArea(radius);
                calculator.getCirculeresult().add(area);
                System.out.println("반지름이 " + radius + "인 원의 넓이는 : " + area);

                System.out.println("저장된 원의 넓이 전체 조회");
                calculator.inquiryCircleresult();
            }
            // 두 와일 문의 와일 부분, exit를 입력받을 경우 종료한다.
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료) ");
            // exit 외에 다른 값을 입력받을경우 다시 do 부분으로 돌아가서 계산을 다시 수행힌다.
        } while (!sc.next().equals("exit"));
    }
}

