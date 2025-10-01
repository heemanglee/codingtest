import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        int[] result = new int[N + 1];
        Queue<Integer> que = new ArrayDeque<>();
        for (int child : graph.get(1)) {
            que.offer(child);
            result[child] = 1;
        }

        while (!que.isEmpty()) {
            int parent = que.poll();
            for (int child : graph.get(parent)) {
                if (result[child] != 0) {
                    continue;
                }
                que.offer(child);
                result[child] = parent;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb);
    }
}