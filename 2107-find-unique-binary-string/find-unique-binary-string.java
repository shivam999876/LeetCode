class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder(n);
        
        for (int i = 0; i < n; i++) {
            char ch = nums[i].charAt(i);
            result.append((ch == '0') ? '1' : '0');
        }
        
        return result.toString();
    }
}