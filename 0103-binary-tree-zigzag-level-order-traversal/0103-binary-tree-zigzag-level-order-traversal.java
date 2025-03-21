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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean reverse = false;
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode  node = que.poll();
                res.add(node.val);
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            if(reverse){
                reverse = false;
                Collections.reverse(res);
            }else{
                reverse = true;
            }
            ans.add(res);
        }

        return ans;
    }
}