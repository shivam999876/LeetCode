class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
// so that we can easily see the freuency of elements
        int right = 0;
// for right index
        int maxCount = 0;
        int left = -1;
// 
        int totalOp = 0;
        int c = 0;
        while(right<nums.length){
            int start = right;
            while(right<nums.length && nums[right] == nums[start]){
                right++;
            }
            int count = right-start;
            if(left==-1 && c<2){
                c++;
                left = start-1;
                totalOp = 0;
                while(left>=0){
                    if(totalOp+nums[start]-nums[left] <= k){
                        totalOp+=(nums[start]-nums[left]);
                        count++;
                    }
                    else{
                        break;
                    }
                    left--;
                }
            }
            else{
                totalOp+=((nums[start]-nums[start-1])*(start-left-1));
                count += start-left-1;
                while(totalOp>k && left<start){
                    totalOp-=  nums[start]-nums[left+1];
                    left++;
                    count--;
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}