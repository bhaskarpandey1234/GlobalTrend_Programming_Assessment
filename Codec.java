package binarytree;


public class Codec {

    // Serialize the tree to a string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    
    // Deserialize the string to a tree
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = {0}; // Use an array to keep track of the index
        return deserializeHelper(nodes, index);
    }
    
    private TreeNode deserializeHelper(String[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]++]));
        root.left = deserializeHelper(nodes, index);
        root.right = deserializeHelper(nodes, index);
        return root;
    }
}
