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
    int min = Integer.MAX_VALUE;
    List<Integer> arr = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        // Collections.sort(arr);
        for(int i = 0;i<arr.size()-1;i++){
            min = Math.min(min,Math.abs(arr.get(i)-arr.get(i+1)));
        }
        return min;
    }
    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }

}