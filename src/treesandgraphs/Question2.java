package treesandgraphs;

import structures.TreeNode;

import static util.TreeUtils.printInOrder;
import static util.TreeUtils.printPreOrder;

/*
Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree
with minimal height.
*/
public class Question2 {
    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4,5,6};
        TreeNode root = createMinimal(arr);

        //printPreOrder(root);
        printInOrder(root);

    }

    public static TreeNode createMinimal(int[] arr){
        return helper(arr,0,arr.length-1);
    }

    private static TreeNode helper(int[] arr, int start, int end){
        if(start <= end){
            int mid = start + (end-start)/2;
            TreeNode root = new TreeNode(arr[mid]);

            root.left = helper(arr, start, mid-1);
            root.right = helper(arr, mid+1, end);

            return root;
        }else{
            return null;
        }
    }
}
