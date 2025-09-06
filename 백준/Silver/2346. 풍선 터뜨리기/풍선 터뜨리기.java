import java.io.*;

public class Main {

    static int N;
    static int[] numbers;
    static boolean[] available;
    static int leastCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        leastCount = N; // 남은 개수

        // 풍선을 터뜨릴 수 있는지 여부
        available = new boolean[N];
        for (int i = 0; i < N; i++) {
            available[i] = true;
        }

        // 각 풍선에 저장된 숫자
        numbers = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int currentIdx = 0; // 현재 위치
        while (leastCount > 0) {
            bw.write((currentIdx + 1) + " "); // 현재 idx 기록
            available[currentIdx] = false;

            if (--leastCount == 0) {
                break;
            }

            int rotateCount = Math.abs(numbers[currentIdx]); // 회전 횟수
            int idx = currentIdx;
            if (numbers[currentIdx] > 0) { // 왼쪽으로 회전
                while (true) {
                    if (++idx >= N) {
                        idx = 0;
                    }

                    if (available[idx]) {
                        rotateCount--;
                    }

                    if (rotateCount == 0) {
                        currentIdx = idx;
                        break;
                    }
                }
            } else { // 오른쪽으로 회전
                while (true) {
                    if (--idx < 0) {
                        idx = N - 1;
                    }

                    if (available[idx]) {
                        rotateCount--;
                    }

                    if (rotateCount == 0) {
                        currentIdx = idx;
                        break;
                    }
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}