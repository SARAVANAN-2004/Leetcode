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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans,0);
        return ans;
    }
    void dfs(TreeNode root,List<Integer> ans, int level){
        if(root == null){
            return;
        }
        if(ans.size()<=level){
            ans.add(root.val);
        }else{
        ans.set(level,Math.max(ans.get(level),root.val));
        }

        dfs(root.left,ans,level+1);
        dfs(root.right,ans,level+1);
    }
}