import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int pick = Integer.parseInt(st.nextToken());
            if (isAvailablePick(list, pick)) {
                list.remove(0);
                continue;
            }

            // 2번 연산과 3번 연산 횟수 비교
            int left = 0;
            List<Integer> tmp1 = new LinkedList<>(list);
            while (true) {
                if (isAvailablePick(tmp1, pick)) {
                    break;
                }
                tmp1.add(tmp1.remove(0));
                left++;
            }

            int right = 0;
            List<Integer> tmp2 = new LinkedList<>(list);
            while (true) {
                if (isAvailablePick(tmp2, pick)) {
                    break;
                }
                int lastIdx = tmp2.size() - 1;
                tmp2.add(0, tmp2.remove(lastIdx));
                right++;
            }

            if (left > right) {
                count += right;
                list = tmp2;
            } else {
                count += left;
                list = tmp1;
            }
            list.remove(0);
        }

        System.out.println(count);
    }

    static boolean isAvailablePick(List<Integer> list, int num) {
        return list.get(0) == num;
    }
}