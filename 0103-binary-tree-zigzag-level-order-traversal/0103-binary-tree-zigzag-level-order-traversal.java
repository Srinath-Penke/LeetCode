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
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        boolean reverse = true;
        while (!q.isEmpty()) {
            int i = 0;
            int size = q.size();

            Integer[] values = new Integer[size];
            while (size-- > 0) {
                TreeNode node = q.poll();
                int index = reverse ? i++ : size;
                values[index] = node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            result.add(Arrays.asList(values));
            reverse = !reverse;
        }

        return result;
    }
}