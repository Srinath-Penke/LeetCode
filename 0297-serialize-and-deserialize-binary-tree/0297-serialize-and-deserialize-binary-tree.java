/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        write(root, sb);
        return sb.toString();
    }

    private void write(TreeNode root, StringBuilder sb) {
        if (sb.length() > 0) sb.append(',');

        if (root == null) {
            sb.append('#');
            return;
        }

        sb.append(root.val);
        write(root.left, sb);
        write(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return read(data, new int[]{0});
    }

    private TreeNode read(String data, int[] index) {
        int start = index[0];
        while (index[0] < data.length() && data.charAt(index[0]) != ',')
            index[0]++;

        String val = data.substring(start, index[0]++);
        if (val.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = read(data, index);
        root.right = read(data, index);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));