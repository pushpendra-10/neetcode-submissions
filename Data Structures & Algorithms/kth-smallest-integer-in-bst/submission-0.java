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
    public void inorder(TreeNode root, int[] ans){
        if(root == null) return;
        inorder(root.left, ans);
        if(ans[1]-- > 0)ans[0] = root.val;
        inorder(root.right, ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        ans[1] = k;
        inorder(root, ans);
        return ans[0];
    }
}
