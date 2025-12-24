package fibo;

public class GreedyExample {
    public static void main(String[] args) {
        int[] coins = {10, 5, 2, 1};
        int amount = 28;

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                System.out.print(coin + " ");
            }
        }
    }
}
