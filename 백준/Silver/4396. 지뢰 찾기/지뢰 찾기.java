import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N x N
        char[][] mines = new char[N][N];
        Queue<int[]> que = new ArrayDeque<>();

        // 지뢰 좌표 저장
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                mines[i][j] = arr[j];
            }
        }

        // 사용자가 선택한 좌표 저장
        for (int y = 0; y < N; y++) {
            char[] arr = br.readLine().toCharArray();
            for (int x = 0; x < N; x++) {
                if (arr[x] == 'x') {
                    que.add(new int[]{y, x});
                }
            }
        }

        String[][] result = new String[N][N];
        boolean isMeetMine = false;

        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int x = pos[1];
            int y = pos[0];

            // 현재 자리에 지뢰가 있을 경우
            if (mines[y][x] == '*') {
                isMeetMine = true;
                continue;
            }

            int mineCount = 0;
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (isNotOutOfRange(nx, ny, N)) {
                    if (mines[ny][nx] == '*') {
                        mineCount++;
                    }
                }
            }
            result[y][x] = mineCount + "";
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (result[y][x] == null) {
                    if (isMeetMine && mines[y][x] == '*') {
                        result[y][x] = "*";
                    } else {
                        result[y][x] = ".";
                    }
                }
                sb.append(result[y][x]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isNotOutOfRange(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}