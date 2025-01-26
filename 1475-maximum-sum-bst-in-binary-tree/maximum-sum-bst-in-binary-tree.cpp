/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
 class nodeValue{
public:
int min;
int max;
int sum;
nodeValue(int min,int max,int sum)
{
this->min=min;
this->max=max;
this->sum=sum;
}
};
class Solution {
public:
int ans=0;
int maxSumBST(TreeNode* root) {
helper(root);
return ans;
}
nodeValue helper(TreeNode* root) {
if(root==NULL)
return nodeValue(INT_MAX,INT_MIN,0);
nodeValue l=helper(root->left);
nodeValue r=helper(root->right); 
if(root->val>l.max && root->val<r.min)
{
ans=max(ans,root->val+l.sum+r.sum);
return
nodeValue(min(root->val,l.min),max(root->val,r.max),l.sum+root->val+r.sum);
}
return nodeValue(INT_MIN,INT_MAX,max(l.sum,r.sum));
}
};
