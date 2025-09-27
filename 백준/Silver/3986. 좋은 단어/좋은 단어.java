import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        Deque<Character> dq = new ArrayDeque<>();
        while (N-- > 0) {
            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (dq.isEmpty()) {
                    dq.offer(c);
                } else {
                    char prev = dq.peekLast();
                    if (prev == c) {
                        dq.pollLast();
                    } else {
                        dq.offer(c);
                    }
                }
            }

            if (dq.isEmpty()) {
                count++;
            }
            dq.clear();
        }

        System.out.println(count);
    }
}