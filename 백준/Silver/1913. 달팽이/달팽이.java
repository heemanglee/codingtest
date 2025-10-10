import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int N, M;

    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int number = 1;
        int dir = -1;
        int x = N / 2, y = N / 2;

        int[] find = new int[2];

        while (true) {
            arr[y][x] = number;
            if (number == M) {
                find[0] = y + 1;
                find[1] = x + 1;
            }

            if (isBreak(number)) break;
            number++;

            int count = 0;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (isNotOutOfRange(nx, ny) && arr[ny][nx] != 0) {
                    count++;
                    if (count >= 2) break;
                }
            }

            if (count <= 1) {
                dir = (dir + 1) % 4;
            }
            x += dx[dir];
            y += dy[dir];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int num : arr[i]) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        sb.append(find[0]).append(" ").append(find[1]);
        System.out.println(sb);
    }

    static boolean isBreak(int number) {
        return number >= N * N;
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}