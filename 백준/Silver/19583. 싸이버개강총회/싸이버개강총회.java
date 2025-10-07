import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        Set<String> entered = new HashSet<>();
        int count = 0;
        String readLine;
        while ((readLine = br.readLine()) != null) {
            String[] split = readLine.split(" ");
            String time = split[0];
            String name = split[1];

            if (time.compareTo(s) <= 0) {
                entered.add(name);
                continue;
            }

            if (time.compareTo(e) >= 0 && time.compareTo(q) <= 0) {
                if (entered.contains(name)) {
                    entered.remove(name);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}