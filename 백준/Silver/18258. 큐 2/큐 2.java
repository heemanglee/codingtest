import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> dq = new ArrayDeque<>();

        int cnt = Integer.parseInt(br.readLine()); // 반복 횟수

        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");

            String command = input[0];
            switch (command) {
                case "push":
                    dq.offer(input[1]);
                    break;
                case "pop":
                    bw.write(isEmpty(dq) ? "-1" : dq.poll());
                    bw.write("\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write((isEmpty(dq) ? "1" : "0") + "\n");
                    break;
                case "front":
                    bw.write(isEmpty(dq) ? "-1" : dq.peek());
                    bw.write("\n");
                    break;
                default:
                    bw.write(isEmpty(dq) ? "-1" : dq.peekLast());
                    bw.write("\n");
            }
        }

        bw.flush();
    }

    static boolean isEmpty(Deque<String> dq) {
        return dq.isEmpty();
    }
}