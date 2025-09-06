import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> dq = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 인원수
        int K = Integer.parseInt(input[1]); // 제거할 숫자

        // 1~N 사람을 원을 이루며 차례대로 세운다
        for (int i = 0; i < N; i++) {
            dq.offer(i + 1);
        }

        bw.write("<");
        // 최종적으로 1명이 남을 때까지 진행한다.
        while (dq.size() > 1) {
            // K - 1번 회전하되, 가장 앞에 있는 사람이 가장 뒤로 이동한다.
            for (int i = 0; i < K - 1; i++) {
                dq.offer(dq.poll());
            }

            bw.write(dq.poll() + ", ");
        }

        bw.write(dq.poll() + ">");

        bw.flush();
        bw.close();
        br.close();
    }
}