import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        int N = Integer.parseInt(br.readLine());
        String[] inputs;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);
            int location = Integer.parseInt(inputs[1]);

            if (map.containsKey(num)) {
                int curLocation = map.get(num);
                if (curLocation != location) {
                    result++;
                }
            }

            map.put(num, location);
        }

        System.out.println(result);
    }
}