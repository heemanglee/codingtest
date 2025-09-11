import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                boolean isEmpty = false;
                if (pq.isEmpty()) {
                    isEmpty = true;
                }
                bw.write((isEmpty ? 0 : pq.poll()) + "\n");
                continue;
            }
            pq.offer(x);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}