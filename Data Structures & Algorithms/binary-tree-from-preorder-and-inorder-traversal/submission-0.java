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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
                int n = preorder.length;
                        int m = inorder.length;

                                return build(0, n - 1, 0, m - 1, preorder, inorder);
                                    }

                                        public TreeNode build(int prelo, int prehi,
                                                                  int inlo, int inhi,
                                                                                            int[] preorder, int[] inorder) {

                                                                                                    // Base case
                                                                                                            if (prelo > prehi || inlo > inhi) {
                                                                                                                        return null;
                                                                                                                                }

                                                                                                                                        // First element of preorder is the root
                                                                                                                                                TreeNode root = new TreeNode(preorder[prelo]);

                                                                                                                                                        // Find root in inorder
                                                                                                                                                                int i = inlo;
                                                                                                                                                                        while (inorder[i] != preorder[prelo]) {
                                                                                                                                                                                    i++;
                                                                                                                                                                                            }

                                                                                                                                                                                                    // Build left subtree
                                                                                                                                                                                                            root.left = build(
                                                                                                                                                                                                                        prelo + 1,
                                                                                                                                                                                                                                    prelo + (i - inlo),
                                                                                                                                                                                                                                                inlo,
                                                                                                                                                                                                                                                            i - 1,
                                                                                                                                                                                                                                                                        preorder,
                                                                                                                                                                                                                                                                                    inorder
                                                                                                                                                                                                                                                                                            );

                                                                                                                                                                                                                                                                                                    // Build right subtree
                                                                                                                                                                                                                                                                                                            root.right = build(
                                                                                                                                                                                                                                                                                                                        prelo + (i - inlo) + 1,
                                                                                                                                                                                                                                                                                                                                    prehi,
                                                                                                                                                                                                                                                                                                                                                i + 1,
                                                                                                                                                                                                                                                                                                                                                            inhi,
                                                                                                                                                                                                                                                                                                                                                                        preorder,
                                                                                                                                                                                                                                                                                                                                                                                    inorder
                                                                                                                                                                                                                                                                                                                                                                                            );

                                                                                                                                                                                                                                                                                                                                                                                                    return root;
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                        }

