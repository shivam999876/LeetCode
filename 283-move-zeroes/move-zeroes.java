class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        // place the pointer j:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // no non-zero elements:
        if (j == -1) return;

        // Move the pointers i and j
        // and swap accordingly:
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap nums[i] & nums[j]:
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}
