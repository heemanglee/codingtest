import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int down;
    static int up;
    static int[] prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int money = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        String[] inputs = br.readLine().split(" ");
        prices = new int[inputs.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(inputs[i]);
        }

        // 준현
        int coin = money;
        int stockCount = 0;
        for (int day = 0; day < prices.length; day++) {
            int stockPrice = prices[day];
            if (coin >= stockPrice) {
                int buyStockCount = coin / stockPrice;
                stockCount += buyStockCount;
                coin -= stockPrice * buyStockCount;
            }
        }
        result.add(coin + prices[prices.length - 1] * stockCount);

        // 성민
        coin = money;
        stockCount = 0;
        for (int day = 1; day < prices.length; day++) {
            if (isUp(day - 1, day)) {
                up++;
                down = 0;
            } else if (isDown(day - 1, day)) {
                down++;
                up = 0;
            } else {
                up = 0;
                down = 0;
            }

            if (up / 3 >= 1) { // 매도
                coin += prices[day] * stockCount;
                stockCount = 0;
            } else if (down / 3 >= 1) { // 매수
                if (coin >= prices[day]) {
                    int stockPrice = prices[day];
                    int buyCount = coin / stockPrice;
                    coin -= stockPrice * buyCount;
                    stockCount += buyCount;
                }
            }
        }
        result.add(coin + prices[prices.length - 1] * stockCount);

        // 출력
        if (result.get(0) > result.get(1)) {
            System.out.println("BNP");
        } else if (result.get(0) < result.get(1)) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static boolean isUp(int prevDay, int curDay) {
        return prices[curDay] > prices[prevDay];
    }

    static boolean isDown(int prevDay, int curDay) {
        return prices[curDay] < prices[prevDay];
    }
}