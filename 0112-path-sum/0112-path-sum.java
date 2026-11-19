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
    public boolean process(TreeNode root, int currentSum, int targetSum) {

        if (root == null) return false;

        int sum = currentSum + root.val;

        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        return process(root.left, sum, targetSum)
            || process(root.right, sum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return process(root, 0, targetSum);
    }
}
