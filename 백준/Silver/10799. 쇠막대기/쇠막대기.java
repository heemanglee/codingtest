import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] cArr = br.readLine().toCharArray();

        int sum = 0;
        int open = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '(') {
                open++;
            } else {
                open--;
                sum += cArr[i - 1] == '(' ? open : 1;
            }
        }

        System.out.println(sum);
    }
}