class Solution {
    public int arraySign(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] == 0)
                return 0;
            else if (nums[i] < 0)
                count++;
        }
        if (count % 2 == 1)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}