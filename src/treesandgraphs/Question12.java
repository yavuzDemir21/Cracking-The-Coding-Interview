package treesandgraphs;

import structures.TreeNode;

import java.util.HashMap;

import static treesandgraphs.Question2.createMinimal;

/*
You are given a binary tree in which each node contains an integer value (which might be positive or negative). Design
an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root
or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class Question12 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1};

        TreeNode root = createMinimal(arr);

        System.out.println(pathsWithSum(root,0));


    }

    static int count = 0;
    static int target;
    static HashMap<Integer, Integer> sumCountMap;

    private static int pathsWithSum(TreeNode root, int value){
        sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);
        target = value;

        if(value == 0) count++;

        dfs(root, 0);

        return count;
    }

    private static void dfs(TreeNode node, int sum){
        if(node != null){

            sum = sum + node.val;
            if(sumCountMap.containsKey(sum-target)){
                count += sumCountMap.get(sum-target);
            }
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
            dfs(node.left, sum);
            dfs(node.right, sum);
            if(sumCountMap.get(sum) == 1) sumCountMap.remove(sum);
            else sumCountMap.put(sum, sumCountMap.get(sum)-1);

        }

    }
}
