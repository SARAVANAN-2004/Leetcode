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
    List<Double> val;
    List<Integer> size ;
    public List<Double> averageOfLevels(TreeNode root) {
        val = new ArrayList<>();
        size = new ArrayList<>();
        dfs(root,1);
        for(int i = 0;i<val.size();i++){
            val.set(i,val.get(i)/size.get(i));
        }
        return val;
    }
    void dfs(TreeNode root,int level){
        if(root == null) return;
        if(val.size() < level){
            val.add(0.0);
            size.add(0);
        }
        val.set(level-1,val.get(level-1) + root.val);
        size.set(level-1,size.get(level-1)+1);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}