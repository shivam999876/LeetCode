class Solution {

    public int sumSubarrayMins(int[] arr) {
        long total=0;
        int mod=(int) 1e9+7;
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, arr.length);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                left[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            } 
            if(!st.isEmpty()){
                right[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<arr.length;i++){
            total+=(long)(i-left[i])*(right[i]-i)%mod*arr[i]%mod;
            total%=mod;
        }
        return (int)total;
    }
}