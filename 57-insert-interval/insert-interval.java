class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        int i =0;
        int n = intervals.length;
        while(i < n && intervals[i][1] < newInterval[0]){
            stack.push(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        stack.push(newInterval);

        while(i < n){
            stack.push(intervals[i]);
            i++;
        }

        return stack.toArray(new int[stack.size()][]);
    }
}