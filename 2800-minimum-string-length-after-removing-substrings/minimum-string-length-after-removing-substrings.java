class Solution {
    public int minLength(String s) {
          StringBuilder sb = new StringBuilder(s);
        int length = sb.length();
        
        boolean found;
        do {
            found = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if ((sb.charAt(i) == 'A' && sb.charAt(i + 1) == 'B') ||
                    (sb.charAt(i) == 'C' && sb.charAt(i + 1) == 'D')) {
                    sb.delete(i, i + 2);
                    length -= 2;
                    found = true;
                    break;
                }
            }
        } while (found);
        
        return length;
    }
}