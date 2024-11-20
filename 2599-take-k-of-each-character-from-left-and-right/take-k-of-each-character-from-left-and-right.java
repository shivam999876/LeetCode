class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        if (Math.min(count[0], Math.min(count[1], count[2])) < k) {
            return -1;
        }
        int res = Integer.MAX_VALUE, l = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;
            while (Math.min(count[0], Math.min(count[1], count[2])) < k) {
                count[s.charAt(l++) - 'a']++;
            }
            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }
}