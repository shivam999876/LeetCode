class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] factors = Arrays.stream(items).mapToInt(item -> item[0]).toArray();
        int[] prices = Arrays.stream(items).mapToInt(item -> item[1]).toArray();
        int top = Arrays.stream(factors).max().getAsInt();
        int[] have = new int[top + 1], gains = new int[top + 1]; 
        for (int factor : factors) have[factor]++;
        for (int factor = 1; factor <= top; factor++)
            for (int multiple = factor; multiple <= top; multiple += factor)  
                gains[factor] += have[multiple];

        int cheapest = Arrays.stream(prices).min().getAsInt();
        int[] best = new int[budget + 1];  
        Arrays.setAll(best, money -> money / cheapest);
        for (int[] item : items) {
            int factor = item[0], price = item[1], gain = gains[factor];
            if (gain > price / cheapest)  
                for (int money = budget; money >= price; money--)  
                    best[money] = Math.max(best[money], best[money - price] + gain);
        }
        return best[budget];
    }
}