package util;

import structures.TreeNode;

public class TreeUtils {

    public static void printInOrder(TreeNode root) {
        if (root.left != null)
            printInOrder(root.left);
        System.out.println(root.val);
        if (root.right != null)
            printInOrder(root.right);
    }
    public static void printPreOrder(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null)
            printPreOrder(root.left);
        if (root.right != null)
            printPreOrder(root.right);
    }
}
