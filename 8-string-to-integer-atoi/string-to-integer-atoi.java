class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        int idx = 0;
        long num = 0;

        // Skip leading spaces
        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        // Check for sign
        if (idx < n && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = (s.charAt(idx) == '-') ? -1 : 1;
            idx++;
        }

        // Iterate through digits
        while (idx < n && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';

            // Check for overflow
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Update num
            num = num * 10 + digit;
            idx++;
        }

        // Apply sign and return the result
        return (int) (sign * num);
    }
}
