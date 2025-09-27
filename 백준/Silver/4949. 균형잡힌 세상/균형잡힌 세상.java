import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] cArr = br.readLine().toCharArray();
            if (cArr.length == 1 && cArr[0] == '.') {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBreak = false;
            for (char c : cArr) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() == '[') {
                        sb.append("no\n");
                        isBreak = true;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() == '(') {
                        sb.append("no\n");
                        isBreak = true;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!isBreak) {
                if (stack.isEmpty()) {
                    sb.append("yes\n");
                } else {
                    sb.append("no\n");
                }
            }
        }

        System.out.println(sb);
    }
}