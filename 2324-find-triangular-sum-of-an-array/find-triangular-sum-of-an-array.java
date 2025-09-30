import java.math.BigInteger;
class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        BigInteger ans = BigInteger.ZERO;
        BigInteger coeff = BigInteger.ONE; 
        for(int i=0;i<n;i++) {
            ans = ans.add(coeff.multiply(BigInteger.valueOf(nums[i])));
            coeff = coeff.multiply(BigInteger.valueOf(n-i-1)).divide(BigInteger.valueOf(i+1));
        }
        return ans.mod(BigInteger.TEN).intValue();
    }
}