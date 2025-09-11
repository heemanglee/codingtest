import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> {
            int abs1 = Math.abs(p1);
            int abs2 = Math.abs(p2);
            if (abs1 == abs2) {
                return p1 - p2;
            }
            return abs1 - abs2;
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                int result = pq.isEmpty() ? 0 : pq.poll();
                bw.write(result + "\n");
                continue;
            }
            pq.offer(x);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}