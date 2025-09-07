import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        int count = 0;

        String name;
        while ((name = br.readLine()) != null) {
            count++;
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
                pq.offer(name);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!pq.isEmpty()) {
            String s = pq.poll();
            double result = map.get(s) * 100.0 / count;
            bw.write(String.format("%s %.4f", s, result) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}