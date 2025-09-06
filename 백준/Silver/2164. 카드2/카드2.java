import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        // 1장만 남을 때까지 반복한다.
        while (dq.size() > 1) {
            dq.poll();
            dq.offer(dq.poll());
        }

        System.out.println(dq.poll());

        bw.close();
        br.close();
    }
}