import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Set<Integer> see = new HashSet<>();
            br.readLine(); // 수첩1 숫자 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                see.add(Integer.parseInt(st.nextToken()));
            }

            br.readLine(); // 수첩2 숫자 개수
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(see.contains(num) ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }
}