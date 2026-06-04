class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){ // cyclic sort
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1)
                return nums[j];
        }
        return -1;
    }
    void swap(int[] nums,int i,int correct){
        int temp=nums[i];
        nums[i]=nums[correct];
        nums[correct]=temp;
    }
}