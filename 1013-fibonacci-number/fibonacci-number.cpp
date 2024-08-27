class Solution {
public:
    int fib(int n) {
        //Tabulation
        if(n<=1)
        return n;
        int curr,prev=1, prev2=0;
        for(int i=2;i<=n;i++){
            curr = prev+prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
};