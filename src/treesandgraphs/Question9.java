package treesandgraphs;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

import static treesandgraphs.Question2.createMinimal;

public class Question9 {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        TreeNode root = createMinimal(arr);

        ArrayList<ArrayList<Integer>> result = BSTSequences(root);

        System.out.println(result.size());

        result.forEach(x -> System.out.println(Arrays.toString(x.toArray())));
    }

    private static ArrayList<ArrayList<Integer>> BSTSequences(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<TreeNode> curList = new ArrayList<>();
        curList.add(root);

        ArrayList<Integer> curSeq = new ArrayList<>();

        helper(result, curSeq, curList);

        return result;


    }

    private static void helper(ArrayList<ArrayList<Integer>> result,
                               ArrayList<Integer> curSeq,
                               ArrayList<TreeNode> curList) {

        if(curList.isEmpty()){
            result.add(curSeq);
        }else{
            int n = curList.size();
            for(int i=0; i<n; i++){
                ArrayList<TreeNode> tempList = new ArrayList<>(curList);
                TreeNode node = tempList.remove(i); // -> O(n)
                if(node.left != null) tempList.add(node.left);
                if(node.right != null) tempList.add(node.right);
                ArrayList<Integer> tempSeq = new ArrayList<>(curSeq);
                tempSeq.add(node.val);
                helper(result, tempSeq, tempList);
            }

        }



    }

}
