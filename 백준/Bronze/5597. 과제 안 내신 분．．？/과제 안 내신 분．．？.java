import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx] = true;
        }

        int count = 0;
        for (int i = 1; i <= 30; i++) {
            if (count >= 2) {
                break;
            }

            if (!arr[i]) {
                System.out.println(i);
                count++;
            }
        }
    }
}