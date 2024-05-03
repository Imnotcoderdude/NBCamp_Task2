package test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class TestCalculator {
    // 사칙연산 계산 수행을 위해 Integer 타입의 리스트 필드 선언
    private List<Integer> results;
    // 원의 넓이 계산 수행을 위해 Double 타입의 리스트 필드 선언
    private List<Double> circuleresult;

    // 생성자, 두개의 리스트를 매개변수로 활용한다.
    public TestCalculator(List<Integer> results, List<Double> circuleresult) {
        this.results = results;
        this.circuleresult = circuleresult;
    }
    // 사칙연산을 수행하는 메서드
    public int calculate(int num1, int num2, char oper) {
        int result = 0;
        // 스위치문을 활용하여 oper의 값에 따라 맞는 연산을 제공한다.
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    // 나눗셈에서 분모에 0이 올 경우 예외처리한다.
                    throw new ArithmeticException("분모에는 0이 올 수 없습니다.");
                }
                break;
            default:
                // 연산 기호를 제대로 입력하지 않을 경우 예외처리를 한다.
                throw new UnsupportedOperationException("정확한 연산 기호를 입력해 주세요");
        }
        // 위 스위치 문에서 나온 결과값을 출력하고 리턴한다.
        System.out.println("연산 결과는 : " + result);
        return result;
    }

    /**
     * 원의 넓이를 구하는 메서드
     *
     * @param radius : 원의 반지름
     * @return 원의 넓이
     */
    public double calculateCircleArea(int radius) {
        return 3.14 * radius * radius;
    }
    // 프라이빗된 result를 사용하기 위한 getter
    public List<Integer> getResults() {
        return results;
    }
    // 프라이빗된 result를 사용하기 위한 setter
    public void setResults(List<Integer> results) {
        this.results = results;
    }
    // remove를 입력받을 경우 인덱스를 학제하기 위한 메서드
    public void removeResult(int index) {
        this.results.remove(index);
    }
    // inquiry를 입력받을 경우 저장된 인덱스를 전부 출력하기 위한 메서드
    public void inquiryResults() {
        for (Integer result : results) {
            System.out.println("저장된 연산 결과: " + result);
        }
    }
    // 원의 넓이 getter
    public List<Double> getCirculeresult() {
        return circuleresult;
    }
    // 원의 넓이 setter
    public void setCirculeresult(List<Double> circuleresult) {
        this.circuleresult = circuleresult;
    }

    public void inquiryCircleresult() {
        for (Double circleresult : circuleresult) {
            System.out.println("원의 넓이 = " + circleresult);
        }
    }
}
