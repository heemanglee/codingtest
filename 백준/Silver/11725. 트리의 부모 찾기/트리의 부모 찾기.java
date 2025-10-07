import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[N + 1];
        int[] result = new int[N + 1];
        visited[1] = true;

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);

        while (!que.isEmpty()) {
            int parent = que.poll();
            for (int child : graph.get(parent)) {
                if (visited[child]) continue;
                result[child] = parent;
                que.offer(child);
                visited[child] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }
}