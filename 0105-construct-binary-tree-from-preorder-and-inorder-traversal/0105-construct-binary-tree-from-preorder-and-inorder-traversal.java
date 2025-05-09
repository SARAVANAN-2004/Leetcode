/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1, hmap);
    }

    private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> hmap) {
        if (start > end) {
            return null;
        }
        int rootval = preorder[index++];
        TreeNode root = new TreeNode(rootval);
        int ind = hmap.get(rootval);
        root.left = helper(preorder, start, ind - 1, hmap);
        root.right = helper(preorder, ind + 1, end, hmap);
        return root;
    }
}
