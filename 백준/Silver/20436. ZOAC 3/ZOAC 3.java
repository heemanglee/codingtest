import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    static Map<Character, int[]> posMap;
    static Set<Character> set1;
    static Set<Character> set2;

    static char[][] arr1 = {
            {'q', 'w', 'e', 'r', 't'},
            {'a', 's', 'd', 'f', 'g'},
            {'z', 'x', 'c', 'v'}
    };
    static char[][] arr2 = {
            {'y', 'u', 'i', 'o', 'p'},
            {'h', 'j', 'k', 'l'},
            {'b', 'n', 'm'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        posMap = new HashMap<>();

        set1 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                posMap.put(arr1[i][j], new int[]{i, j});
                set1.add(arr1[i][j]);
            }
        }

        set2 = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                posMap.put(arr2[i][j], new int[]{i, arr1[i].length + j});
                set2.add(arr2[i][j]);
            }
        }

        String[] inputs = br.readLine().split(" ");
        char left = inputs[0].charAt(0);
        char right = inputs[1].charAt(0);

        int count = 0;
        for (char c : br.readLine().toCharArray()) {
            int[] cur, next;
            if (set1.contains(c)) {
                cur = posMap.get(left);
                next = posMap.get(c);
                count += Math.abs(cur[0] - next[0]) + Math.abs(cur[1] - next[1]) + 1;
                left = c;
            } else {
                cur = posMap.get(right);
                next = posMap.get(c);
                count += Math.abs(cur[0] - next[0]) + Math.abs(cur[1] - next[1]) + 1;
                right = c;
            }
        }

        System.out.println(count);
    }
    
}