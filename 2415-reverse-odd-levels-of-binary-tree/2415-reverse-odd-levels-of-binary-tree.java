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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            List<TreeNode> nodes = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = q.poll();
                nodes.add(node);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            // Reverse values at odd levels
            if (level % 2 == 1) {
                int left = 0;
                int right = nodes.size() - 1;

                while (left < right) {
                    int temp = nodes.get(left).val;
                    nodes.get(left).val = nodes.get(right).val;
                    nodes.get(right).val = temp;

                    left++; right--;
                }
            }

            level++;
        }

        return root;
    }
}
