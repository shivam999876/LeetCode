class Solution {
public:
    vector<vector<int>> result;  // stores all subsets

    void backtrack(int index, vector<int>& nums, vector<int>& current) {
        // Every state is a valid subset
        result.push_back(current);

        // Explore further elements
        for (int i = index; i < nums.size(); i++) {
            current.push_back(nums[i]);          // include nums[i]
            backtrack(i + 1, nums, current);     // move to next element
            current.pop_back();                  // backtrack/remove last element
        }
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> current;
        backtrack(0, nums, current);
        return result;
    }
};
