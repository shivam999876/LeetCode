class Solution {
    public int singleNonDuplicate(int[] nums){
        int l = 0,h = nums.length - 1;
        while(l < h){
            int mid = (h - l) / 2 + l;
            if((mid > 0 && nums[mid] == nums[mid - 1])){
                if((mid + 1) % 2 == 1){
                    h = mid - 2;
                }
                else{
                    l = mid + 1;
                } 
            }
            else{
                if((mid) % 2 == 1){
                    h = mid - 1;
                }
                else{
                    l = mid;
                }
            }
        }
        return nums[l];
    }
}