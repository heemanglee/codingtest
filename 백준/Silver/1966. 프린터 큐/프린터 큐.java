import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            char find = (char) (m + 'a');
            Map<Character, Integer> map = new HashMap<>();
            Queue<Character> que = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (int) b - (int) a);

            inputs = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                pq.offer(Integer.parseInt(inputs[i]));
                char key = (char) (i + 'a');
                que.offer(key);
                map.put(key, Integer.parseInt(inputs[i]));
            }

            int count = 1;
            int high = pq.poll();
            while (true) {
                char poll = que.poll();
                if (map.get(poll) == high) {
                    if (poll == find) {
                        sb.append(count).append("\n");
                        break;
                    } else {
                        count++;
                        high = pq.poll();
                    }
                } else {
                    que.offer(poll);
                }
            }
        }

        System.out.println(sb);
    }
}