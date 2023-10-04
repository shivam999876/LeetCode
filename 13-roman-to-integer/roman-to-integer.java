class Solution {
     public int romanToInt(String str) {
   
        Map<Character, Integer> romanMap = new HashMap<>();
        int n = str.length();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (romanMap.get(str.charAt(i)) < romanMap.get(str.charAt(i + 1))) {
                sum -= romanMap.get(str.charAt(i));
            } else {
                sum += romanMap.get(str.charAt(i));
            }
        }
        sum += romanMap.get(str.charAt(n - 1));
        return sum;
    }
}