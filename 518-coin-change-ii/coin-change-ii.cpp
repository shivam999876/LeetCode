#include <vector>
#include <limits>
using namespace std;
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<unsigned long long>> dp(n + 1, vector<unsigned long long>(amount + 1, 0));
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    unsigned long long include = dp[i][j - coins[i - 1]];
                    unsigned long long exclude = dp[i - 1][j];
                    if (include > numeric_limits<unsigned long long>::max() - exclude) {
                        return 0;
                    }
                    dp[i][j] = include + exclude;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return static_cast<int>(dp[n][amount]);
    }
};