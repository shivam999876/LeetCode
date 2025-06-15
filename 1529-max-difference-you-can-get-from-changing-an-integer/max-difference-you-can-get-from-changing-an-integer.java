class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        char[] maxChars = s.toCharArray();
        char[] minChars = s.toCharArray();
        int n = s.length();

        // Maximize number: The first digit < '9' should be made '9'
        for (int i = 0; i < n; ++i) {
            if (maxChars[i] != '9') {
                char target = maxChars[i];
                for (int j = 0; j < n; ++j) {
                    if (maxChars[j] == target) {
                        maxChars[j] = '9';
                    }
                }
                break;
            }
        }

        // Minimize number
        if (minChars[0] > '1') {
            char target = minChars[0];
            for (int i = 0; i < n; ++i) {
                if (minChars[i] == target) {
                    minChars[i] = '1';
                }
            }
        } else {
            // Find first digit > '0' from index 1 to (n-1)
            for (int i = 1; i < n; ++i) {
                if (minChars[i] > '1') {
                    char target = minChars[i];
                    for (int j = i; j < n; ++j) {
                        if (minChars[j] == target) {
                            minChars[j] = '0';
                        }
                    }
                    break;
                }
            }
        }

        int maxNum = Integer.parseInt(new String(maxChars));
        int minNum = Integer.parseInt(new String(minChars));
        return maxNum - minNum;
    }
}