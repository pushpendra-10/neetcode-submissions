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
    public int levels(TreeNode root, int[] ans){
        if(root == null) return 0;
        int left = levels(root.left, ans);
        int right = levels(root.right, ans);
        ans[0] = Math.max(ans[0], left+right);
        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = 0;
        levels(root, ans);
        return ans[0];
    }
}
