class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // if(k==0) return 0;
        int r=0,l=0,p=1,ans=0;

        for(r=0;r<nums.length;r++){
            if(p<k) ans++;
            p*=nums[r];
            while(p>=k && l<=r){
                p/=nums[l];
                l++;
            }
            if(p<k) ans+= r - l;
            System.out.println(nums[r]+" "+p);
        }
        return ans;
    }
}