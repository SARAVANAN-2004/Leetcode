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
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null){
            sum += root.val;
            if(sum == targetSum){
                return true;
            }else{
                sum -= root.val;
                return false;
            }
        }
        sum += root.val;

        boolean found = hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
        
        sum -= root.val;
        
        return found;
        
    }
   
    
}