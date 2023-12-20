class Solution {
    public int buyChoco(int[] prices, int money) {
         int minPrice1 = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice1) {
                minPrice2 = minPrice1;
                minPrice1 = price;
            } else if (price < minPrice2) {
                minPrice2 = price;
            }
        }

        int leftover = money - (minPrice1 + minPrice2);
        return leftover >= 0 ? leftover : money;
    }
}