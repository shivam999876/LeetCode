class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        // Step-1: Assign increasing curve with increasing candies
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = 1 + candies[i-1];
            }
        }
        
        // Step-2: Assign decreasing curve with increasing candies
        int total = candies[n-1];
        for (int i = n-1; i > 0; --i) {
            if (ratings[i-1] > ratings[i]) {
                candies[i-1] = Math.max(candies[i-1], 1 + candies[i]);
            }
            total += candies[i-1];
        }
        
        return total;
    }
}