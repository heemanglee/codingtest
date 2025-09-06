import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> dq = new ArrayDeque<>();

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            boolean isEmpty = dq.isEmpty();
            switch (command) {
                case "push_front":
                    dq.offerFirst(input[1]);
                    break;
                case "push_back":
                    dq.offer(input[1]);
                    break;
                case "pop_front":
                    bw.write(((isEmpty ? "-1" : dq.poll())) + "\n");
                    break;
                case "pop_back":
                    bw.write(((isEmpty ? "-1" : dq.pollLast())) + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write((isEmpty ? "1" : "0") + "\n");
                    break;
                case "front":
                    bw.write(((isEmpty ? "-1" : dq.peek())) + "\n");
                    break;
                default:
                    bw.write((isEmpty ? "-1" : dq.peekLast()) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}