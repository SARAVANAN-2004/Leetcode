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
class BSTIterator {
    List<Integer> arr;
    int i = 0;
    int size;

    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        dfs(root);
        size = arr.size();
        
    }

    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }
    
    public int next() {
        i++;
        return arr.get(i-1);
    }
    
    public boolean hasNext() {
        return i < size;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */