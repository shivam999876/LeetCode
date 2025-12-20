class Solution {
    public int minDeletionSize(String[] strs) {
        int results = 0;
        for(int c = 0; c < strs[0].length(); c++){
            for(int r = 0; r < strs.length - 1; r++){
                if(strs[r].charAt(c) > strs[r+1].charAt(c)){
                    results += 1;
                    break;
                }
            }
        } 
        return results;
    }
}