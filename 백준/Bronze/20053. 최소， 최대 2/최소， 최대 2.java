import java.io.*;

public class Main {

    static int min;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            int N = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            for (String input : inputs) {
                int num = Integer.parseInt(input);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            bw.write((min + " " + max) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}