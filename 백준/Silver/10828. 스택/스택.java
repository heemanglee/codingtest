import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            switch (command) {
                case "push":
                    stack.push(input[1]);
                    break;
                case "pop":
                    bw.write((isEmpty(stack) ? "-1" : stack.pop()) + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    bw.write((isEmpty(stack) ? "1" : "0") + "\n");
                    break;
                default:
                    bw.write((isEmpty(stack) ? "-1" : stack.peek()) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isEmpty(Stack<String> stack) {
        return stack.isEmpty();
    }
}