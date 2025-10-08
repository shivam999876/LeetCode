class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;

        Arrays.sort(potions);
        int maxPotion = potions[n - 1];

        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int spell = spells[i];
            long minPotion = (long) Math.ceil((1.0 * success) / spell);

            if (minPotion > maxPotion) {
                answer[i] = 0;
                continue;
            }

            int index = lowerBound(potions, (int) minPotion);
            answer[i] = n - index;
        }

        return answer;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}