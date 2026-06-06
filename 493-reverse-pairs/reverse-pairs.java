import java.util.*;

class Solution {
   public int reversePairs(int[] nums) {
       return mergeSort(nums, 0, nums.length - 1);
   }
   
   private static void merge(int[] nums, int low, int mid, int high) {
       ArrayList<Integer> temp = new ArrayList<>();
       int left = low;
       int right = mid + 1;
       
       while (left <= mid && right <= high) {
           if (nums[left] <= nums[right]) {
               temp.add(nums[left++]);
           } else {
               temp.add(nums[right++]);
           }
       }
       while (left <= mid) temp.add(nums[left++]);
       while (right <= high) temp.add(nums[right++]);
       
       for (int i = low; i <= high; i++) {
           nums[i] = temp.get(i - low);
       }
   }
   
   private static int CountPairs(int[] nums, int low, int mid, int high) {
       int cnt = 0;
       int right = mid + 1;
       for (int i = low; i <= mid; i++) {
           while (right <= high && (long) nums[i] > 2L * nums[right]) {
               right++;
           }
           cnt += (right - (mid + 1));
       }
       return cnt;
   }
   
   private static int mergeSort(int[] nums, int low, int high) {
       if (low >= high) return 0;
       int mid = (low + high) / 2;
       int cnt = mergeSort(nums, low, mid);
       cnt += mergeSort(nums, mid + 1, high);
       cnt += CountPairs(nums, low, mid, high);
       merge(nums, low, mid, high);
       return cnt;
   }
}