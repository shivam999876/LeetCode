/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
         stack<int> s;
        ListNode* slow = head;
        ListNode* fast = head;

        // Push the first half of the list onto the stack
        while (fast && fast->next) {
            s.push(slow->val);
            slow = slow->next;
            fast = fast->next->next;
        }

        // Skip the middle element if the list has an odd number of nodes
        if (fast) slow = slow->next;

        // Compare the second half of the list with the stack
        while (slow) {
            if (s.top() != slow->val) return false;
            s.pop();
            slow = slow->next;
        }

        return true;
    }
};