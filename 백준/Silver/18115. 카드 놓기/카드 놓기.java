import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.offer(i);
        }

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            int order = Integer.parseInt(inputs[i]);
            result[findInsertIdx(dq, order)] = (result.length - i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    static int findInsertIdx(Deque<Integer> dq, int order) {
        switch (order) {
            case 1:
                return dq.poll();
            case 2:
                int tmp = dq.poll();
                int returnNum = dq.poll();
                dq.offerFirst(tmp);
                return returnNum;
            case 3:
                return dq.pollLast();
        }
        return -1;
    }
}