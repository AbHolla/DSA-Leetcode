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


    private static final int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        // Step 1: Compute total sum of all nodes
        totalSum = computeTotalSum(root);

        // Step 2: Compute max product by trying all splits
        computeSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    private long computeTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val 
                + computeTotalSum(node.left) 
                + computeTotalSum(node.right);
    }

    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long leftSum = computeSubtreeSum(node.left);
        long rightSum = computeSubtreeSum(node.right);

        long currentSum = leftSum + rightSum + node.val;

        // Product if we cut above this subtree
        long product = currentSum * (totalSum - currentSum);

        // Update maximum product
        maxProduct = Math.max(maxProduct, product);
        return currentSum;
    }
}
