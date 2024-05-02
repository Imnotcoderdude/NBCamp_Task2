package test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class TestCalculator {

    private List<Integer> results;
    private List<Double> circuleresult;

    public TestCalculator(List<Integer> results, List<Double> circuleresult) {
        this.results = results;
        this.circuleresult = circuleresult;
    }

    public int calculate(int num1, int num2, char oper) {
        int result = 0;

        switch (oper) {
            case '+':
                result = num1 + num2;
            case '-':
                result = num1 - num2;
            case '*':
                result = num1 * num2;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("분모에는 0이 올 수 없습니다.");
                }
                break;
            default:
                throw new UnsupportedOperationException("정확한 연산 기호를 입력해 주세요");
        }
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

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public void removeResult(int index) {
        this.results.remove(index);
    }

    public void inquiryResults() {
        for (Integer result : results) {
            System.out.println("저장된 연산 결과: " + result);
        }
    }

    public List<Double> getCirculeresult() {
        return circuleresult;
    }

    public void setCirculeresult(List<Double> circuleresult) {
        this.circuleresult = circuleresult;
    }

    public void inquiryCircleresult() {
        for (Double circleresult : circuleresult) {
            System.out.println("원의 넓이 = " + circleresult);
        }
    }
}
