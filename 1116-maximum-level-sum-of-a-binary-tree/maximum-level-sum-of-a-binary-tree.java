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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        int level=1;
        int answerLevel=1;
        int maxSum=Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int size=queue.size();
            int currSum=0;

            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                currSum+=node.val;

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            if(currSum>maxSum){
                maxSum=currSum;
                answerLevel=level;
            }
            level++;
        }
        return answerLevel;
    }
}