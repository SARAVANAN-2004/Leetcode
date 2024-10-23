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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        root.val = 0;

        while (!temp.isEmpty()) {
            int lsize = temp.size();
            int totalSum = 0;

            Map<TreeNode, Integer> cousins = new HashMap<>();
            for (int i = 0; i < lsize; i++) {
                TreeNode node = temp.poll();
                int childsum = 0;

                if (node.left != null) {
                    temp.add(node.left);
                    childsum += node.left.val;
                }

                if (node.right != null) {
                    temp.add(node.right);
                    childsum += node.right.val;
                }

                cousins.put(node, childsum);
                totalSum += childsum;
            }

            for (Map.Entry<TreeNode, Integer> entry : cousins.entrySet()) {
                TreeNode node = entry.getKey();
                int childsum = entry.getValue();

                if (node.left != null)
                    node.left.val = totalSum - childsum;

                if (node.right != null)
                    node.right.val = totalSum - childsum;
            }
        }

        return root;
    }
}