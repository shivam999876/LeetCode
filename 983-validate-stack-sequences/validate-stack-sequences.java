class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
            stack.push(pushed[i]);
        }
        while (!stack.empty() && popped[j] == stack.peek()) {
            stack.pop();
            j++;
        }
        return stack.empty() && j == n;
    }
}