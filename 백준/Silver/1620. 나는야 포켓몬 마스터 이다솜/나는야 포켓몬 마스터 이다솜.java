import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> map = new HashMap<>();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String idx = (i + 1) + "";
            map.put(idx, input);
            map.put(input, idx);
        }

        for (int i = 0; i < M; i++) {
            bw.write(map.get(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}