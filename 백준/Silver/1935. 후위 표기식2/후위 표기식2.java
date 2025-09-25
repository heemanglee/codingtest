import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] cArr = br.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            char c = (char) ('A' + i);
            map.put(c, num);
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (isAlphabet(c)) {
                stack.push((double) map.get(c));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double calculateResult = calculate(a, b, c);
                stack.push(calculateResult);
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));
    }

    static boolean isAlphabet(char c) {
        return c >= 'A' && c <= 'Z';
    }

    static double calculate(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a % b;
            default:
                throw new IllegalArgumentException();
        }
    }
}