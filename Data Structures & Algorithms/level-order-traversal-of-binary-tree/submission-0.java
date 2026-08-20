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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int prevLvl = 0;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            Pair p = q.poll();
            int lvl = p.level;
            TreeNode top = p.node;
            if(lvl != prevLvl){
                ans.add(list);
                list = new ArrayList<>();
                prevLvl++;
            }
            list.add(top.val);
            if(top.left!=null)q.add(new Pair(top.left, lvl+1));
            if(top.right!=null)q.add(new Pair(top.right, lvl+1));
        }
        ans.add(list);
        return ans;
    }
}
