import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isDelete = new boolean[N + 1];
        int deleteCount = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!isDelete[j]) {
                    isDelete[j] = true;
                    deleteCount++;
                }

                if (deleteCount == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}