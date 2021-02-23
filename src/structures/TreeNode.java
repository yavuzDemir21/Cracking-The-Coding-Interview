package structures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(TreeNode node){
        this.val = node.val;
        this.left = node.left;
        this.right = node.right;
        this.parent = node.parent;
    }
}
