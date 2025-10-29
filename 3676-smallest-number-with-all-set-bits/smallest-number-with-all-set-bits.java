class Solution {     
    boolean isAllBitsSet(int x) {         
        return (x & (x + 1)) == 0;     
    }     

    public int smallestNumber(int n) {         
        int result = n;         
        while (!isAllBitsSet(result)) {             
            result++;         
        }         
        return result;     
    } 
}
