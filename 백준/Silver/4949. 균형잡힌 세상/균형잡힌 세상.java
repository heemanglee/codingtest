import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String inputs = br.readLine();
            if (inputs.equals(".")) {
                break;
            }

            Deque<Character> dq = new ArrayDeque<>();
            boolean ok = true;

            for (int i = 0; i < inputs.length(); i++) {
                char c = inputs.charAt(i);
                switch (c) {
                    case '(':
                    case '[':
                        dq.push(c);
                        break;
                    case ')':
                        if (dq.isEmpty() || dq.peek() != '(') {
                            ok = false;
                            break;
                        } else {
                            dq.pop();
                        }
                        break;
                    case ']':
                        if (dq.isEmpty() || dq.peek() != '[') {
                            ok = false;
                            break;
                        } else {
                            dq.pop();
                        }
                        break;
                    default:
                }

                if (!ok) break;
            }

            sb.append(ok && dq.isEmpty() ? "yes\n" : "no\n");
        }

        System.out.println(sb);
    }
}