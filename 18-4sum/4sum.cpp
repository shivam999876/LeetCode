class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        set<vector<int>> st; 
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
                            vector<int> quad;
                            quad.push_back(nums[i]);
                            quad.push_back(nums[j]);
                            quad.push_back(nums[k]);
                            quad.push_back(nums[mid]);
                            st.insert(quad);
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
        vector<vector<int>> ans(st.begin(), st.end()); 
        return ans;
    }
};
