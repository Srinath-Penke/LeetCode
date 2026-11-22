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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if (root == null) return result;

        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();

            Integer val = null;
            while (size-- > 0) {
                TreeNode node = q.poll();
                
                if (val == null) {
                    val = node.val;
                    result.add(val);
                }

                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
        }

        return result;
    }
}