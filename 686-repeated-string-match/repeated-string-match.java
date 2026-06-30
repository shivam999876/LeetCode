class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int ans = 1;
        while(sb.length() < b.length()) {
            sb.append(a);
            ans++;
        }
        if(sb.toString().contains(b)) return ans;
        sb.append(a);
        if(sb.toString().contains(b)) return ans + 1;
        return -1;
    }
}