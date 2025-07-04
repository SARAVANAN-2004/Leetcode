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
    List<Integer> arr = new ArrayList<>();
    public void flatten(TreeNode root) {
        preorder(root);
        
        if(root == null)return;
        
        for(int i = 1;i<arr.size();i++){

            root.left = null;
            root.right = new TreeNode(arr.get(i));
            root = root.right;
        }
        
    }

    void preorder(TreeNode root){
        if(root == null){
            return;
        }
        arr.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}