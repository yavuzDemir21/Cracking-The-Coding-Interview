package treesandgraphs;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static treesandgraphs.Question2.createMinimal;

/*
T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to determine if T2 is a
subtree
of T1.
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is,
if you cut off the tree at node n, the two trees would be identical.
 */
public class Question10 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        TreeNode root = createMinimal(arr);

        TreeNode root2 = root.left.right;

        System.out.println(checkSubtree(root, root2));




    }

    private static boolean checkSubtree(TreeNode root1, TreeNode root2){

        if(root2 == null) return true;

        TreeNode startingNode = findStartingNode(root1, root2);
        if(startingNode == null) return false;

        return checkEqualTrees(startingNode, root2);
    }

    private static boolean checkEqualTrees(TreeNode big, TreeNode small) {
        if(big != small) return false;

        Queue<TreeNode> smallQu = new LinkedList<>();
        Queue<TreeNode> bigQu = new LinkedList<>();

        smallQu.add(small);
        bigQu.add(big);

        while(!smallQu.isEmpty()){
            TreeNode smallNode = smallQu.poll();
            TreeNode bigNode = bigQu.poll();

            System.out.println(smallNode.val + " " + bigNode.val);

            if(smallNode.left != null){
                if(bigNode.left == null) return false;
                if(smallNode.left != bigNode.left) return false;

                smallQu.add(smallNode.left);
                bigQu.add(bigNode.left);
            }

            if(smallNode.right != null){
                if(bigNode.right == null) return false;
                if(smallNode.right != bigNode.right) return false;

                smallQu.add(smallNode.right);
                bigQu.add(bigNode.right);
            }

        }

        return true;
    }

    private static TreeNode findStartingNode(TreeNode root, TreeNode target){
        if(root == target) return root;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()){
            TreeNode node = qu.poll();

            if(node.left != null){
                if(node.left == target) return node.left;
                qu.add(node.left);
            }

            if(node.right != null){
                if(node.right == target) return node.right;
                qu.add(node.right);
            }

        }

        return null;
    }

}
