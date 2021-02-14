package treesandgraphs;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static treesandgraphs.Question2.createMinimal;

/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
(e.g., if you have a tree with depth D, you'll have D linked lists).
*/
public class Question3 {
    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4,5,6};
        TreeNode root = createMinimal(arr);

        ArrayList<ArrayList<Integer>> lists = treeToList(root);

        lists.forEach(x -> System.out.println(Arrays.toString(x.toArray())));


    }

    private static ArrayList<ArrayList<Integer>> treeToList(TreeNode root){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> qu = new LinkedList<>();
        ArrayList<Integer> curList = new ArrayList<>();
        curList.add(root.val);
        boolean seen = true;
        int seenVal = root.val;
        qu.add(root);

        while(!qu.isEmpty()){
            TreeNode curNode = qu.remove();

            if(curNode.val == seenVal){
                result.add(curList);
                curList = new ArrayList<>();
                seen = false;
            }

            if(curNode.left != null){
                if(!seen){
                    seenVal = curNode.left.val;
                    seen = true;
                }
                curList.add(curNode.left.val);
                qu.add(curNode.left);
            }

            if(curNode.right != null){
                if(!seen){
                    seenVal = curNode.right.val;
                    seen = true;
                }
                curList.add(curNode.right.val);
                qu.add(curNode.right);
            }

        }

        if(!curList.isEmpty()) result.add(curList);

        return result;
    }
}
