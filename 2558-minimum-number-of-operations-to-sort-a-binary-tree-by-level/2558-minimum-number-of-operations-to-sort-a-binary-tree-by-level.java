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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int swap = 0;
        while(!qu.isEmpty()){
            int size = qu.size();
            int[] original = new int[size];
            for(int i = 0;i<size;i++){
               TreeNode node = qu.poll();
               original[i] = node.val;

               if(node.left != null) qu.add(node.left);
               if(node.right != null) qu.add(node.right);
            }
            swap += minSwaps(original);
            
        }
        return swap;
    }

    public int minSwaps(int[] original){
        int[] ans = original.clone();
        Arrays.sort(ans);
        int n = ans.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0 ;i<n;i++){
            map.put(original[i],i);
        }
        int swaps = 0;
        for(int i = 0;i<n;i++){
            if(original[i] != ans[i]){
                swaps++;
                int pos  = map.get(ans[i]);
                map.put(original[i],pos);
                original[pos] = original[i];
            }
        }
        return swaps;
    }
}