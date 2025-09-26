import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int next = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input > next) { // Queue에 수열 삽입
                for (int num = next + 1; num <= input; num++) {
                    if (!visited[num]) {
                        visited[num] = true;
                        pq.offer(num);
                        sb.append("+\n");
                    }
                }
                pq.poll();
                sb.append("-\n");
                next = input;
            } else { // pop
                if (pq.peek() != input) {
                    System.out.println("NO");
                    return;
                }
                pq.poll();
                sb.append("-\n");
            }
        }

        System.out.println(sb);
    }
}