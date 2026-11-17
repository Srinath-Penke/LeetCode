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
    TreeNode nullCase = new TreeNode(-101);

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            Deque<TreeNode> nodes = new ArrayDeque<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left == null) {
                   nodes.offer(nullCase);
                } else {
                    nodes.offer(left);
                    q.offer(left);
                }
                if (right == null) {
                   nodes.offer(nullCase);
                } else {
                    nodes.offer(right);
                    q.offer(right);
                }
            }

            if (nodes.size() % 2 != 0) return false;
            while (!nodes.isEmpty()) {            
                TreeNode first = nodes.removeFirst();
                TreeNode last = nodes.removeLast();

                if (first == nullCase || last == nullCase) {
                    if (first != last) return false;
                } else {
                    if (first.val != last.val) return false;
                } 
            }
        }
        
        return true;
    }
}