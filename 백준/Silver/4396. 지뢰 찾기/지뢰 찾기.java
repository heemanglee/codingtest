import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N x N

        // 지뢰 좌표 저장
        char[][] mine = new char[N][N];
        for (int y = 0; y < N; y++) mine[y] = br.readLine().toCharArray();

        // 현재 좌표 상태 저장
        char[][] open = new char[N][N];
        for (int y = 0; y < N; y++) open[y] = br.readLine().toCharArray();

        // 출력할 배열
        char[][] result = new char[N][N];
        for (int y = 0; y < N; y++) Arrays.fill(result[y], '.');

        boolean isMeetMine = false;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (open[y][x] == 'x') {
                    if (mine[y][x] == '*') {
                        isMeetMine = true;
                    } else {
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (isNotOutOfRange(nx, ny, N) && mine[ny][nx] == '*') {
                                cnt++;
                            }
                        }
                        result[y][x] = (char) ('0' + cnt);
                    }
                }
            }
        }

        if (isMeetMine) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (mine[y][x] == '*') result[y][x] = '*';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < N; y++) sb.append(result[y]).append("\n");

        System.out.println(sb);
    }

    static boolean isNotOutOfRange(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}