import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<StringBuilder> list = new ArrayList<>();
        for (char c : br.readLine().toCharArray()) {
            if (list.isEmpty()) {
                StringBuilder s = new StringBuilder(c + "");
                list.add(s);
            } else {
                int idx = getIdx(c, list);
                if (idx == -1) {
                    list.add(new StringBuilder(c + ""));
                } else {
                    list.get(idx).append(c);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            StringBuilder s = list.get(i);
            // 울음 소리가 quack이 아니거나, quack으로 연속되지 않는 경우
            if (s.length() < 5 || s.length() % 5 != 0) {
                System.out.println(-1);
                return;
            } else {
                String substring = s.substring(0, 5);
                if ("quack".equals(substring)) { // 새로운 오리
                    count++;
                } else { // 울음 소리가 quack가 아닌 경우
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }

    private static int getIdx(char c, List<StringBuilder> list) {
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            StringBuilder s = list.get(i);
            char last = s.charAt(s.length() - 1);
            if (last == 'q' && c == 'u') {
                idx = i;
                break;
            } else if (last == 'u' && c == 'a') {
                idx = i;
                break;
            } else if (last == 'a' && c == 'c') {
                idx = i;
                break;
            } else if (last == 'c' && c == 'k') {
                idx = i;
                break;
            } else if (last == 'k' && c == 'q') {
                idx = i;
                break;
            }
        }
        return idx;
    }
}