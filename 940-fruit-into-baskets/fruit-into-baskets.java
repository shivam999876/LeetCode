class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (i < fruits.length) {
            fruitCount.put(fruits[i], fruitCount.getOrDefault(fruits[i], 0) + 1);
            while (fruitCount.size() > 2) {
                int count = fruitCount.get(fruits[j]) - 1;
                fruitCount.put(fruits[j], count);
                if (count == 0) {
                    fruitCount.remove(fruits[j]);
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }
}