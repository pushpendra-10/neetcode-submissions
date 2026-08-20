/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans = 0;
    public int levels(TreeNode root){
        if(root == null) return 0;

        int left = levels(root.left);
        int right = levels(root.right);

        ans = Math.max(ans, Math.abs(left-right));

        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        levels(root);
        
        if(ans <= 1) return true;
        return false;
    }
}
