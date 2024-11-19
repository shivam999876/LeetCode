class Solution {
    private static void swap(int [] array,int first,int second){
        int temp=array[first];
        array[first]=array[second];
        array[second]=temp;

    }
    public int firstMissingPositive(int[] nums) {
        for  (int i=0;i<nums.length;i++){
            while (nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                swap (nums,i,nums[i]-1);

            }
        }
for (int j=0;j<nums.length;j++){
    if (nums[j]!=j+1){
        return j+1;

    }
}
return nums.length+1;

   
        
    }
}