package treesandgraphs;

import structures.TreeNode;

/*
Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. You may
assume that each node has a link to its parent.
 */
public class Question6 {
    public static void main(String[] args) {

    }
    public static TreeNode findInOrderSuccessor(TreeNode node){
        if(node == null) return null;

        if(node.right != null) return findRightLeaf(node.right);
        else return findSuccessorParent(node);
    }

    private static TreeNode findSuccessorParent(TreeNode node) {
        while(node.parent != null && node == node.parent.right)
            node = node.parent;

        return node.parent;
    }

    private static TreeNode findRightLeaf(TreeNode node) {
        while(node.right != null) node = node.right;
        return node;
    }
}
