import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int[][] arr;
    static int N;

    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        Map<Integer, int[]> posMap = new HashMap<>();
        int number = 1, dir = 0;
        int x = N / 2, y = N / 2;

        posMap.put(number, new int[]{y, x});
        arr[y][x] = number++;
        x += dx[dir];
        y += dy[dir];

        while (true) {
            posMap.put(number, new int[]{y, x});
            arr[y][x] = number++;

            int count = 0;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (isNotOutOfRange(nx, ny) && arr[ny][nx] != 0) {
                    count++;
                    if (count >= 2) break;
                }
            }

            if (count <= 1) dir = (dir + 1) % 4;
            y += dy[dir];
            x += dx[dir];

            if (isBreak(number)) break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for (int num : arr[i]) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        int[] pos = posMap.get(Integer.parseInt(br.readLine()));
        sb.append((pos[0] + 1)).append(" ").append(pos[1] + 1);

        System.out.println(sb);
    }

    static boolean isBreak(int curNum) {
        return curNum > N * N;
    }

    static boolean isNotOutOfRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}