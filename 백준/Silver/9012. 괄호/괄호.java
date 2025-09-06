import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack;
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            stack = new Stack<>();

            char[] cArr = br.readLine().toCharArray();
            boolean isStop = false;
            for (int j = 0; j < cArr.length; j++) {
                char c = cArr[j];

                // 열린 괄호일 때
                if (c == '(') {
                    stack.push(c);
                    continue;
                }

                // 닫힌 괄호일 때
                if (stack.isEmpty()) {
                    isStop = true;
                    break;
                }
                stack.pop();
            }

            if (isStop || !stack.isEmpty()) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}