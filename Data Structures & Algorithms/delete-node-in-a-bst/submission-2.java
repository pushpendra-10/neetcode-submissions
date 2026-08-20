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
    public TreeNode leftMax(TreeNode root){
        TreeNode max = root.left;
        while(max.right != null){
            max = max.right;
        }
        return max;
    }
    public TreeNode preLeft(TreeNode root){
        TreeNode preNode = root.left;
        if(preNode.right == null) return root;
        while(preNode.right.right != null){
            preNode = preNode.right;
        }
        return preNode;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key){
            // case 1: 0 child
            if(root.left == null && root.right == null) return null;

            // case 2: 1 child
            else if(root.left == null || root.right == null){
                if(root.left == null) return root.right;
                if(root.right == null) return root.left;
            }

            // case 3: 2 child
            else{
                TreeNode node = leftMax(root);
                TreeNode preNode = preLeft(root); 
                if(preNode == root){
                    node.right = root.right;
                    return node;
                }
                preNode.right = null;
                node.left = root.left;
                node.right = root.right;
                return node;
            }
        }
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}