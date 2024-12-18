class Solution {
public:
    void swap(vector<int> &nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void rev(vector<int> &nums, int i, int j)
    {
        while (i <= j)
        {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    void nextPermutation(vector<int> &nums)
    {
        int n = nums.size();
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
        {
            i--;
        }
        if (i < 0)
        {
            rev(nums, 0, n - 1);
        }
        else
        {
            int j = n - 1;
            while (nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums, i, j);
            rev(nums, i + 1, n - 1);
    }
    }
};