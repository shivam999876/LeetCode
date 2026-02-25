class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boundArr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            boundArr[i] = arr[i];
        }
        Arrays.sort(boundArr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if(countA == countB){
                return a.compareTo(b);
            }
            return Integer.compare(countA, countB);
        });
        for(int i = 0; i < arr.length; i++){
            arr[i] = boundArr[i];
        }
        return arr;
    }
}