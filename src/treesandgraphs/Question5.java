package treesandgraphs;

import structures.TreeNode;

import static treesandgraphs.Question2.createMinimal;

/*
Implement a function to check if a binary tree is a binary search tree.
 */
public class Question5 {
    public static void main(String[] args) {
        int[] arr = {10,2,31,14,5,6,7};

        TreeNode root = createMinimal(arr);

        System.out.println(validateBST(root));

    }

    public static boolean validateBST(TreeNode root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, int min, int max){
        if(root == null) return true;

        return root.val < max && root.val >= min &&
                helper(root.left, min, root.val) &&
                helper(root.right, root.val, max);

    }

}
