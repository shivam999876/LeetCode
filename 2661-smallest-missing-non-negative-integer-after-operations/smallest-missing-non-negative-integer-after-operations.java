class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int r = ((num % value) + value) % value;
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        int MEX = 0;
        while(map.getOrDefault(MEX % value, 0) > 0){
            map.put(MEX % value, map.get(MEX % value) - 1);
            MEX++;
        }
        return MEX;
    }
}