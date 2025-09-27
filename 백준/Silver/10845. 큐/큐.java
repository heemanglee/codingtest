import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<String> dq = new ArrayDeque<>();

        while (N-- > 0) {
            String line = br.readLine();
            if (line.startsWith("push")) {
                dq.offer(line.split(" ")[1]);
            } else if (line.startsWith("pop")) {
                sb.append(dq.isEmpty() ? "-1" : dq.poll()).append("\n");
            } else if (line.startsWith("size")) {
                sb.append(dq.size()).append("\n");
            } else if (line.startsWith("empty")) {
                sb.append(dq.isEmpty() ? "1" : "0").append("\n");
            } else if (line.startsWith("front")) {
                sb.append(dq.isEmpty() ? "-1" : dq.peek()).append("\n");
            } else if (line.startsWith("back")) {
                sb.append(dq.isEmpty() ? "-1" : dq.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}