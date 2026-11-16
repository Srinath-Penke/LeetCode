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

        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            int size = que.size();

            while (size-- > 0) {
                TreeNode node = que.poll();
                levelValues.add(node.val);

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }

            result.add(levelValues);
        }

        return result;       
    }
}