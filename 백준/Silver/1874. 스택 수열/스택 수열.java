import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        int next = 0;
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input > next) {
                for (int i = next + 1; i <= input; i++) {
                    st.push(i);
                    sb.append("+\n");
                }
                st.pop();
                sb.append("-\n");
                next = input;
            } else {
                if (st.peek() != input) {
                    System.out.println("NO");
                    return;
                }
                st.pop();
                sb.append("-\n");
            }
        }

        System.out.println(sb);
    }
}