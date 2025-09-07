import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            set.add(i);
        }

        for (int i = 0; i < 28; i++) {
            set.remove(Integer.parseInt(br.readLine()));
        }

        List<Integer> list = new ArrayList<>(set);
        for (int num : list) {
            System.out.println(num);
        }
    }
}