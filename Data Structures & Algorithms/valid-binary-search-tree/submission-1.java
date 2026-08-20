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

    public boolean isValidBST(TreeNode root) {
        int[] prev = new int[1];
        prev[0] = Integer.MIN_VALUE;

        return inorder(root, prev);
    }

    public boolean inorder(TreeNode root, int[] prev) {
        if (root == null) {
            return true;
        }
        if(!inorder(root.left, prev)) return false;
        if (root.val <= prev[0]) {
            return false;
        }
        prev[0] = root.val;
        return inorder(root.right, prev);
    }
}
