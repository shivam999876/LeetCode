class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApple = 0;
        for(int a : apple){
            totalApple += a;
        }
        int[] freq = new int[51];
        for(int cap : capacity){
            freq[cap]++;
        }
        int count = 0;
        for(int cap = 50; cap >= 1 && totalApple > 0; cap--){
            while(freq[cap] > 0 && totalApple > 0){
                totalApple -= cap;
                freq[cap]--;
                count++;
            }
        }
        return count;
    }
}