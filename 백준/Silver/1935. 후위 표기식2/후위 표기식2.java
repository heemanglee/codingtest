import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] cArr = br.readLine().toCharArray();

        double[] dArr = new double[26];
        for (int i = 0; i < N; i++) {
            dArr[i] = Double.parseDouble(br.readLine());
        }

        Deque<Double> st = new ArrayDeque<>();
        for (char c : cArr) {
            if (isAlphabet(c)) {
                st.push(dArr[c - 'A']);
            } else {
                double b = st.pop();
                double a = st.pop();
                st.push(calculate(a, b, c));
            }
        }

        System.out.printf("%.2f", st.pop());
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
            default:
                throw new IllegalArgumentException();
        }
    }
}