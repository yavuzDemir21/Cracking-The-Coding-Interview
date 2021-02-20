package treesandgraphs;

import structures.TreeNode;

/*
Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing
additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
public class Question8 {
    public static void main(String[] args) {

    }

    //Assume no link to parent node

    // if you are in a node and find node1 in your left and find node2 in your right return that node
    //
    private static TreeNode firstCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2){

        return findClosestAncestor(root, node1, node2);

    }

    private static TreeNode findClosestAncestor(TreeNode root, TreeNode node1, TreeNode node2){

        if(root == null) return null;

        boolean isNode1OnTheLeft = contains(root.left, node1);
        boolean isNode2OnTheLeft = contains(root.left, node2);

        if(isNode1OnTheLeft != isNode2OnTheLeft){
            return root;
        }else if(isNode1OnTheLeft){
            return findClosestAncestor(root.left, node1, node2);
        }else{
            return findClosestAncestor(root.right, node1, node2);
        }

    }

    private static boolean contains(TreeNode root, TreeNode target){
        if(root == null) return false;
        if(root == target) return true;

        return contains(root.left, target) || contains(root.right, target);
    }


}
