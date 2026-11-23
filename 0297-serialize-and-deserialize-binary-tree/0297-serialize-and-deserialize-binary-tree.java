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
        List<String> tree = new ArrayList<>();
        write(root, tree);
        return String.join(",", tree);
    }

    public void write(TreeNode root, List<String> tree) {
        if (root == null) {
            tree.add("#");
            return;
        }
        tree.add(String.valueOf(root.val));
        write(root.left, tree);
        write(root.right, tree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> tree = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return read(tree);
    }

    public TreeNode read(Deque<String> tree) {
        String val = tree.poll();
        if (val.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = read(tree);
        root.right = read(tree);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));