class Solution {
    public int minOperations(String[] logs) {
        int x = 0;
    for (String it : logs) {
        if (it.equals("../")) {
            x = Math.max(0, x - 1);
        } else if (it.equals("./")) {
            continue;
        } else {
            x++;
        }
    }
    return x;
    }
}