class Solution {
    static boolean binarySearch(int nums[],int target,int left,int right){
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] == nums[right] && nums[mid] == nums[left]){
                left++;
                right--;
            }
            else if(nums[mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }

        return false;
    }

    public static int findPivot(int nums[]){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid < right && nums[mid] >nums[mid + 1])
                return mid;
            if(mid > left && nums[mid] < nums[mid - 1])
                return mid - 1;
            if(nums[mid] < nums[left])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return 0;
    }
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        return binarySearch(nums,target,0,pivot) || binarySearch(nums,target,pivot+1,nums.length-1);
    }
}