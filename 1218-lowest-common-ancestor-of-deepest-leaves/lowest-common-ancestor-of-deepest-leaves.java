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
    private static class Result {
        int depth;
        TreeNode node;

        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
    private Result dfs(TreeNode root) {
        // Base case
        if (root == null) {
            return new Result(0, null);
        }

        // Recurse on left and right
        Result left = dfs(root.left);
        Result right = dfs(root.right);

        // If left subtree is deeper
        if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        }

        // If right subtree is deeper
        if (right.depth > left.depth) {
            return new Result(right.depth + 1, right.node);
        }

        // If both depths are equal → current node is LCA
        return new Result(left.depth + 1, root);
    }

}