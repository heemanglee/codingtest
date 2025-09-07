import java.io.*;

public class Main {

    static int N, M;
    static boolean[] lights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        lights = new boolean[N + 1];
        inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(inputs[i - 1]);
            lights[i] = num == 1;
        }

        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int command = Integer.parseInt(inputs[0]);
            int l = Integer.parseInt(inputs[1]);
            int r = Integer.parseInt(inputs[2]);

            switch (command) {
                case 1:
                    command1(l, r);
                    break;

                case 2:
                    command2(l, r);
                    break;
                case 3:
                    command3(l, r);
                    break;
                default:
                    command4(l, r);
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write((lights[i] ? 1 : 0) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void command1(int idx, int x) {
        lights[idx] = x == 1;
    }

    static void command2(int l, int r) {
        for (int idx = l; idx <= r; idx++) {
            lights[idx] = !lights[idx];
        }
    }

    static void command3(int l, int r) {
        for (int idx = l; idx <= r; idx++) {
            lights[idx] = false;
        }
    }

    static void command4(int l, int r) {
        for (int idx = l; idx <= r; idx++) {
            lights[idx] = true;
        }
    }
}