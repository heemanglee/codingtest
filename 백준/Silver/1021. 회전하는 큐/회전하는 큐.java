import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            int pick = Integer.parseInt(st.nextToken());

            int left = list.indexOf(pick);
            int right = list.size() - left;

            if (left > right) {
                for (int i = 0; i < right; i++) {
                    list.addFirst(list.removeLast());
                }
                count += right;
            } else {
                for (int i = 0; i < left; i++) {
                    list.addLast(list.removeFirst());
                }
                count += left;
            }

            list.removeFirst();
        }

        System.out.println(count);
    }
}