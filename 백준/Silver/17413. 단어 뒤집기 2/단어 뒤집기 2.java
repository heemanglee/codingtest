import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '<') {
                consume(stack, sb);

                sb.append(c);
                for (int j = i + 1; j < arr.length; j++) {
                    sb.append(arr[j]);
                    if (arr[j] == '>') {
                        i = j;
                        break;
                    }
                }
            } else {
                if (c == ' ') {
                    consume(stack, sb);
                    sb.append(" ");
                } else {
                    stack.push(c);
                }
            }
        }

        consume(stack, sb);
        System.out.println(sb);
    }

    private static void consume(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}