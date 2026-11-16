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
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;

        Deque<TreeNode> q1 = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();
        result.add(List.of(root.val));
        q1.offer(root);

        while (!q1.isEmpty()) {
            TreeNode item = q1.poll();
            if (item.left != null) q2.offer(item.left);
            if (item.right != null) q2.offer(item.right);

            if (q1.isEmpty() && !q2.isEmpty()) {
                List<Integer> result2 = new ArrayList<>();
                while (!q2.isEmpty()) {
                    TreeNode temp = q2.poll();
                    result2.add(temp.val);
                    q1.offer(temp);
                }
                result.add(result2);
            }
        }

        return result;       
    }
}