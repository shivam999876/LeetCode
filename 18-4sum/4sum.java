class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long newtarget = target;
                    newtarget -= nums[i];
                    newtarget -= nums[j];
                    newtarget -= nums[k];
                    // Binary search to find element newtarget in nums from k + 1 to n
                    int low = k + 1;
                    int high = n - 1;
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        if (nums[mid] == newtarget) {
                            List<Integer> quad = new ArrayList<>();
                            quad.add(nums[i]);
                            quad.add(nums[j]);
                            quad.add(nums[k]);
                            quad.add(nums[mid]); 
                            set.add(quad);
                            break;
                        } else if (nums[mid] < newtarget) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
