class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0, n = prices.size();
    vector<int> maxPrice(n);
    maxPrice[n - 1] = prices[n - 1];
    for (int i = n - 2; i >= 0; --i)
    {
        maxPrice[i] = max(maxPrice[i + 1], prices[i]);
    }
    for (int i = 0; i < n; ++i)
    {
        profit = max(profit, maxPrice[i] - prices[i]);
    }
    return profit;
    }
};