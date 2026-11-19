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

    public void dfs(TreeNode root, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;

        path.add(root.val);
        remaining -= root.val;
        if (root.left == null && root.right == null) {
            if (remaining == 0) {
                result.add(new ArrayList<>(path));
            }
        } else {
            dfs(root.left, remaining, path, result);
            dfs(root.right, remaining, path, result);

        }
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }
}