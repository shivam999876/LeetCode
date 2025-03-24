class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> time = new ArrayList<>();
        for (int[] meeting : meetings) {
            time.add(new int[]{meeting[0], 1});
            time.add(new int[]{meeting[1] + 1, 0});
        }
        
        // Sort the time list
        time.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        // Apply Line-Sweep 1D
        int overlap = 0;
        int count = time.get(0)[0] - 1; // Count free time before start
        for (int i = 0; i < time.size() - 1; ++i) {
            if (time.get(i)[1] == 0) overlap--;
            else overlap++;
            
            if (overlap == 0) {
                count += time.get(i + 1)[0] - time.get(i)[0];
            }
        }
        
        count += days - time.get(time.size() - 1)[0] + 1; // Count free time after end
        return count;
    }
}