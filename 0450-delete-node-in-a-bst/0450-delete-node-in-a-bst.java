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
    TreeNode prev = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode node = find(root,key);
        if(node  == null) return root;

        if(node.left  == null && node.right == null){
            if(prev == null) return null;
            if(key < prev.val ){
                prev.left = null;
            }else{
                prev.right = null;
            }
        }else{
            if(node.left  == null || node.right == null){
                if(prev == null) return node.left == null?node.right :node.left;
                if(key < prev.val){
                    if(node.left == null){
                        prev.left = node.right;
                    }else{
                        prev.left = node.left;
                    }
                }else{
                    if(node.left == null){
                        prev.right = node.right;
                    }else{
                        prev.right = node.left;
                    }
                }
                
            }else{
                TreeNode next  = node.right;
                if(prev == null){
                    root = node.left;
                }
                else if(key < prev.val ){
                    prev.left = node.left;
                    
                }else{
                    prev.right = node.left;
                }
                TreeNode leaf = node.left;
                TreeNode ptr = node.left;
                while(ptr != null){
                    leaf = ptr;
                    ptr = ptr.right;
                }
                leaf.right = next;
            }

        }
        return root;
    }

    TreeNode find(TreeNode root,int key){
        if(root == null) return null;
        if(root.val == key) return root;
        prev = root;
        if(root.val < key) return find(root.right,key);
        return find(root.left,key);
        
    }
}