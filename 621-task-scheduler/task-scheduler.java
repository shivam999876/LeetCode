class Solution {

    private void sort(int arr[]){
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 0;i<arr.length;i++){
      list.add(arr[i]);
    }
    Collections.sort(list);
    for(int i = 0;i<arr.length;i++){
      arr[i] = list.get(i);
    }
  }

  private boolean isallequal(int arr[]){
    for(int i = 0;i<26;i++){
        if(arr[i] != 0) return false;
    }
    return true;
  }
    public int leastInterval(char[] tasks, int k) {
        int arr[] = new int[26];
        Arrays.fill(arr,0);
        int n = tasks.length;
        for(int i = 0;i<n;i++){
            char ch = tasks[i];
            arr[ch-'A']++;
        }
        sort(arr);
        int x = k+1;
        int y = 25;
        int ans = 0;
        while(arr[25] != 0){
            while(x>0){
                if(y>= 0 && arr[y] != 0){
                    arr[y]--;
                    if(isallequal(arr)) return ans+1; 
                }
                y--;
                x--;
                ans++;
            }
            x = k+1;
            y = 25;
            sort(arr);
        }
        return ans;
    }
}