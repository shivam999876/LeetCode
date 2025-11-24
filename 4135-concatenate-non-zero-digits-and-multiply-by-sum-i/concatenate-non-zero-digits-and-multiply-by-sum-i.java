class Solution {
    public long sumAndMultiply(int n) {
        String s =Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        int dS = 0;
        for(char c : s.toCharArray()){
            if(c != '0'){
                sb.append(c);
                dS += c - '0';
            }
        }
        long x = sb.length() == 0 ? 0 : Long.parseLong(sb.toString());
        return x * dS;
    }
}