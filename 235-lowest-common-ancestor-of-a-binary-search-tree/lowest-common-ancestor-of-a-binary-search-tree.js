/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    let traverse=(curr)=>{
        if(p.val <curr.val && q.val <curr.val){
            return traverse(curr.left,p,q);
        }
        else if(p.val >curr.val && q.val >curr.val){
            return traverse(curr.right,p,q);
        }else{
            return curr;
        }
        
    }
    return traverse(root);
    
};