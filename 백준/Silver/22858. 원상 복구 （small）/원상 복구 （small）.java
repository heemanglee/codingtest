import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] pArr;
    static int[] dArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pArr = new int[N];
        dArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dArr[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] tmp = new int[N];
        while (M-- > 0) {
            for (int i = 0; i < N; i++) {
                int num = pArr[i];
                int moveIdx = dArr[i];
                tmp[moveIdx] = num;
            }

            // Object.clone(): O(N) 발생 -> 1회 셔플할 때마다 O(2N)이 발생.
            int[] t = pArr;
            pArr = tmp;
            tmp = t;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(pArr[i]).append(" ");
        }
        System.out.println(sb);
    }
}