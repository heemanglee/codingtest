import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final int N = 5;
    static boolean[][] visited;
    static Map<Integer, int[]> posMap;
    static int bingoCount;
    
    static int[] dyCount;
    static int[] dxCount;
    static int diagRightCount;
    static int diagLeftCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visited = new boolean[N][N];
        posMap = new HashMap<>();

        String[] inputs;
        for (int y = 0; y < N; y++) {
            inputs = br.readLine().split(" ");
            for (int x = 0; x < N; x++) {
                posMap.put(Integer.parseInt(inputs[x]), new int[]{y, x});
            }
        }

        dyCount = new int[N];
        dxCount = new int[N];

        int tellCount = 0;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int[] pos = posMap.get(Integer.parseInt(inputs[j]));
                int y = pos[0], x = pos[1];

                tellCount++;

                dyCount[y]++;
                if (dyCount[y] == N) {
                    bingoCount++;
                }

                dxCount[x]++;
                if (dxCount[x] == N) {
                    bingoCount++;
                }

                if (y == x) {
                    diagRightCount++;
                    if (diagRightCount == N) {
                        bingoCount++;
                    }
                }

                if (y + x == N - 1) {
                    diagLeftCount++;
                    if (diagLeftCount == N) {
                        bingoCount++;
                    }
                }

                if (bingoCount >= 3) {
                    System.out.println(tellCount);
                    return;
                }
            }
        }
    }
}