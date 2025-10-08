import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Pair> pairSet = new TreeSet<>();
        Map<Integer, Pair> pairMap = new HashMap<>();

        StringTokenizer st;
        int p, l, x;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(p, l);
            pairSet.add(pair);
            pairMap.put(p, pair);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "add":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());

                    Pair old = pairMap.get(p);
                    if (old != null) {
                        pairSet.remove(old);
                    }

                    Pair pair = new Pair(p, l);
                    pairSet.add(pair);
                    pairMap.put(p, pair);
                    break;
                case "recommend":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(x == -1 ? pairSet.first().p : pairSet.last().p).append("\n");
                    break;
                case "solved":
                    p = Integer.parseInt(st.nextToken());
                    pairSet.remove(pairMap.get(p));
                    pairMap.remove(p);
            }
        }

        System.out.println(sb);
    }

    static class Pair implements Comparable<Pair> {
        int p; // 문제 번호
        int l; // 난이도

        public Pair(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.l == o.l) return Integer.compare(this.p, o.p);
            return Integer.compare(this.l, o.l);
        }
    }
}