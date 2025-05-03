class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = solve(tops, bottoms, tops[0]);
        if(count1 != -1)
            return count1;
        return solve(tops, bottoms, bottoms[0]);
        
    }
    int solve(int[] tops, int[] bottoms, int target){
        int flipTop = 0;
        int flipBottom = 0;
        int n = tops.length;

        for(int i=0;i<n;i++){
            if(tops[i] != target && bottoms[i] != target)
                return -1;
            else if(tops[i] != target){
                flipTop++;
            }else if(bottoms[i] != target){
                flipBottom++;
            }
        }
        int res = Math.min(flipTop, flipBottom);
        return res;
    }
}