class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long gap = 0;
        long min_val = 0;
        long max_val = 0;
        long curr_val = 0;
        for (int ele : differences) {
            curr_val += ele;
            min_val = Math.min(min_val, curr_val);
            max_val = Math.max(max_val, curr_val);
        }
        long count = (upper - lower) - (max_val - min_val) + 1;
        return count > 0 ? (int) count : 0;
    }
}
