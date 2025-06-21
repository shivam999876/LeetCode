class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] updated = new int[26];
        int size = 0;
        for (int f : freq) {
            if (f > 0) updated[size++] = f;
        }
        Arrays.sort(updated, 0, size);
        int min = Integer.MAX_VALUE;          
        int totalSum = word.length();         
        int deletedLeftSum = 0;              
        int sumInWindow = 0;                
        int j = 0;                          
        for (int i = 0; i < size; i++) {
            int from = updated[i];
            int to = from + k;
            while (j < size && updated[j] <= to) {
                sumInWindow += updated[j++];
            }
            int countRight = size - j;
            int sumRight = totalSum - sumInWindow;
            int deletionsRight = sumRight - countRight * to;
            int totalDel = deletedLeftSum + deletionsRight;
            min = Math.min(min, totalDel);
            totalSum -= updated[i];
            deletedLeftSum += updated[i];
            sumInWindow -= updated[i];
        }
        return min;
    }
}