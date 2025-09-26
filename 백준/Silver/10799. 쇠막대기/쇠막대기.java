import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] cArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        char prev = '(';
        for (char c : cArr) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (prev == '(') { // 막대기 사이 레이저
                    sum += stack.size();
                } else { // 막대디 끝
                    sum += 1;
                }
            }
            prev = c;
        }

        System.out.println(sum);
    }
}