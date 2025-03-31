class Solution {
       public long putMarbles(int[] weights, int k) {
       int n = weights.length - 1;
       int[] wgt = new int[n];
       for (int i = 0; i < n; i++) 
           wgt[i] = weights[i] + weights[i+1];
       Arrays.sort(wgt);
       long res = 0;
       for (int i = 0; i < k - 1; i++) 
           res += (long) wgt[n-1-i] - wgt[i];
       return res;
   }
}