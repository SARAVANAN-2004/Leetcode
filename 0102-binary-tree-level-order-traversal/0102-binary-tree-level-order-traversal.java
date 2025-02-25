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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        if(root == null) return  res;
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            int size = que.size();
            for(int i = 0;i<size;i++){
                // System.out.println(i+" "+que);
                TreeNode node = que.poll();
                if(node == null) continue;
                cur.add(node.val);
                if(node.left != null)
                que.add(node.left);
                if(node.right != null)
                que.add(node.right);
            }
            res.add(cur);
        }

        return res;
    }
}