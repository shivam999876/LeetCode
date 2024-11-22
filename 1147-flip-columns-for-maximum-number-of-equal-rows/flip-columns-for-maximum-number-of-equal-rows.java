class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> count = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder key = new StringBuilder();
            boolean flip = row[0] == 1;
            
            for (int num : row) {
                key.append(flip ? 1 - num : num);
            }
            
            String rowKey = key.toString();
            count.put(rowKey, count.getOrDefault(rowKey, 0) + 1);
        }
        int max = 0;
        for (int freq : count.values()) {
            max = Math.max(max, freq);
        }
        
        return max;
    }
}
