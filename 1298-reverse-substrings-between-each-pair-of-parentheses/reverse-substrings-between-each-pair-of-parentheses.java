class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                StringBuilder curr = new StringBuilder();
                
                while (st.peek() != '(') {
                    curr.append(st.pop());
                }
                
                st.pop(); // Remove the '(' from the stack
                
                for (int j = 0; j < curr.length(); j++) {
                    st.push(curr.charAt(j));
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : st) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
