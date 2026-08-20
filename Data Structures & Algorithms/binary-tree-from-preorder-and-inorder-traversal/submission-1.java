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
    int preindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n-1, map);
    }
    public TreeNode buildTree(int[] preorder, int left, int right, HashMap<Integer, Integer> map){
        if(left > right) return null;

        int rootValue = preorder[preindex++];
        TreeNode root = new TreeNode(rootValue);

        int mid = map.get(rootValue);

        root.left = buildTree(preorder, left, mid-1, map);
        root.right = buildTree(preorder, mid+1, right, map);

        return root;
    }
}
