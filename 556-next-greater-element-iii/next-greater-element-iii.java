class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
    
    // Find the first digit from the right that is smaller than the digit to its right
    int i = digits.length - 2;
    while (i >= 0 && digits[i] >= digits[i + 1]) {
        i--;
    }
    
    // If there is no such digit, then n is the largest possible permutation
    if (i == -1) {
        return -1;
    }
    
    // Find the smallest digit to the right of i that is greater than digits[i]
    int j = digits.length - 1;
    while (j > i && digits[j] <= digits[i]) {
        j--;
    }
    
    // Swap digits[i] and digits[j]
    char temp = digits[i];
    digits[i] = digits[j];
    digits[j] = temp;
    
    // Reverse the digits to the right of i
    reverse(digits, i + 1);
    
    try {
        // Convert the modified char array back to an integer
        long result = Long.parseLong(new String(digits));
        
        // Check if the result is within the 32-bit integer range
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        
        return (int) result;
    } catch (NumberFormatException e) {
        return -1;
    }
}

private void reverse(char[] arr, int start) {
    int end = arr.length - 1;
    while (start < end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
}