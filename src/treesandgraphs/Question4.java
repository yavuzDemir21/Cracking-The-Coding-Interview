package treesandgraphs;

import structures.TreeNode;

import java.util.HashMap;

import static treesandgraphs.Question2.createMinimal;

/*
Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
*/
public class Question4 {
    public static void main(String[] args) {


        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        TreeNode root = createMinimal(arr);

        System.out.println(checkBalanced(root));

    }

    static HashMap<TreeNode, Integer> map = new HashMap<>();

    private static boolean checkBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1 &&
                checkBalanced(root.left) &&
                checkBalanced(root.right);
    }


    private static int height(TreeNode root) {
        if (root == null) return -1;
        if(!map.containsKey(root)){
            map.put(root, Math.max(height(root.left), height(root.right)) + 1);
        }
        return map.get(root);
    }

}
