class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] list1=new int[nums.length];
        int[] list2=new int[nums.length];  
        int prod=1;
        for(int i=0;i<nums.length;i++)
        {
            prod=prod*nums[i];
            list1[i]=prod;
        }
        prod=1;
        for(int j=nums.length-1;j>=0;j--)
        {
            prod=prod*nums[j];
            list2[j]=prod;
        }
        int[] arr=new int[nums.length];
        arr[0]=list2[1];
        arr[nums.length-1]=list1[nums.length-2];
        for(int i=1;i<nums.length-1;i++)
        {
            arr[i]=list1[i-1]*list2[i+1];
        }
        return arr;
    }
}