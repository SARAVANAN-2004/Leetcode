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
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



class Solution {
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public void findLevelSum(TreeNode root, int l, long[] levelSum) {
        if (root == null) {
            return;
        }
        levelSum[l] += root.val;
        findLevelSum(root.left, l + 1, levelSum);
        findLevelSum(root.right, l + 1, levelSum);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        // Step 1: Find the height of the binary tree
        int h = height(root);
        
        // Step 2: If the total number of levels is less than k, return -1
        if (h < k) {
            return -1;
        }
        
        // Step 3: Initialize an array to store the sum of values at each level
        long[] levelSum = new long[h];
        findLevelSum(root, 0, levelSum);
        
        // Step 4: Sort the level sums in descending order
        Arrays.sort(levelSum);
        reverse(levelSum);
        
        // Step 5: Return the k-th largest sum
        return levelSum[k - 1];
    }

    private void reverse(long[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            long temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}