class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        long long left = *max_element(nums.begin(), nums.end()), right = 0, ans = 0;
    for (int num : nums)
        right += num;
    while (left <= right)
    {
        long long mid = left + (right - left) / 2, sum = 0;
        int count = 1;
        for (int num : nums)
        {
            if (sum + num > mid)
            {
                sum = num;
                count++;
            }
            else
            {
                sum += num;
            }
        }
        if (count <= k)
        {
            ans = mid;
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }
    return ans;
    }
};