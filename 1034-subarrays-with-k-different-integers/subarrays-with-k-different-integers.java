class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> aToB = new HashMap<>(); // [a, b)
        Map<Integer, Integer> aToC = new HashMap<>(); // [a, c)
        int a = 0, b = 0, c = 0; // a <= b <= c
        int count = 0;
        while (true) {
            while (aToB.size() < k && b < nums.length) {
                add(aToB, nums[b]); b++;
            }
            while (aToC.size() <= k && c < nums.length) {
                add(aToC, nums[c]); c++;
            }
            // Subarray from [a, b) to [a, c) has k distinct numbers in them.
            count += c - b;
            // If c == nums.length, we don't know if [a, c] should count or not.
            if (aToC.size() == k) {
                count++;
            }
            if (a == nums.length) {
                break;
            }
            remove(aToB, nums[a]);
            remove(aToC, nums[a]);
            a++;
        }
        return count;
    }

    static void add(Map<Integer, Integer> aToB, int c) {
        aToB.put(c, aToB.getOrDefault(c, 0) + 1);
    }

    static void remove(Map<Integer, Integer> aToB, int c) {
        int left = aToB.getOrDefault(c, 0) - 1;
        if (left == 0) {
            aToB.remove(c);
        } else {
            aToB.put(c, left);
        }
    }
}