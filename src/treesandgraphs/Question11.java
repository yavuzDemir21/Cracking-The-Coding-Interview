package treesandgraphs;

/*
You are implementing a binary search tree class from scratch, which, in addition to insert, find, and delete, has a
method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen.
Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.
*/


import structures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class BSTWithGetRandom {

    HashMap<TreeNode, Integer> map;
    ArrayList<TreeNode> list;
    int pointer;
    TreeNode root;

    public BSTWithGetRandom() {
        root = null;
        list = new ArrayList<>();
        map = new HashMap<>();
        pointer = 0;
    }

    public TreeNode find(int val) {
        return find(val, root);
    }

    private TreeNode find(int val, TreeNode node) {
        if (node == null) return null;

        if (node.val == val) return node;
        else if (node.val > val) return find(val, node.left);
        else return find(val, node.right);

    }

    public void insert(int val) {
        if (root == null) root = new TreeNode(val);
        TreeNode node = insert(val, root, null);
        if(node != null){
            list.add(node);
            map.put(node, list.size()-1);
        }
    }

    private TreeNode insert(int val, TreeNode node, TreeNode parent) {

        if (node == null) {
            TreeNode newNode = new TreeNode(val);
            if (val > parent.val) parent.right = newNode;
            else if (val < parent.val) parent.left = newNode;
            return newNode;
        } else {
            if (node.val > val) return insert(val, node.left, node);
            else if (node.val < val) return insert(val, node.right, node);
            else return null;
        }

    }

    public void delete(int val){
        if(root == null) return;

        if(root.val == val){
            if(root.right == null) root = root.left;
            else{
                TreeNode leftMostOnRight = findLeftMostOnRight(root.right);
                leftMostOnRight.left = root.left;
                root = root.right;
            }
        }

        TreeNode deleted = deleteAndRepair(root, val);

        if(deleted != null){
            removeFromLists(deleted);
        }


    }

    private void removeFromLists(TreeNode deleted) {
        int loc = map.get(deleted);
        map.put(list.get(list.size()-1), loc);
        list.set(loc, list.get(list.size()-1));
        map.remove(deleted);
        list.remove(list.size()-1);
    }

    private TreeNode findLeftMostOnRight(TreeNode node) {
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    private TreeNode deleteAndRepair(TreeNode node, int val){

        if(node.right != null && node.right.val == val){
            if(node.right.right == null) node.right = node.right.left;
            else{
                TreeNode leftMostOnRight = findLeftMostOnRight(node.right.right);
                leftMostOnRight.left = node.right.left;
                node.right = node.right.right;
            }
            return node.right;
        }else if(node.left != null && node.left.val == val){
            if(node.left.right == null) node.left = node.left.left;
            else{
                TreeNode leftMostOnRight = findLeftMostOnRight(node.left.right);
                leftMostOnRight.left = node.left.left;
                node.left = node.left.right;
            }
            return node.left;
        }else{
            if(node.val > val){
                if(node.left != null) return deleteAndRepair(node.left, val);
            }else{
                if(node.right != null) return deleteAndRepair(node.right, val);
            }

        }

        return null;
    }


    public TreeNode getRandomNode(){
        Random random = new Random();
        int loc = random.nextInt(list.size()-pointer) + pointer;
        TreeNode node = list.get(loc);
        swap(pointer, loc);
        pointer = (pointer+1)%list.size();
        return node;

    }

    private void swap(int pointer, int loc) {
        TreeNode temp = list.get(pointer);
        list.set(pointer, list.get(loc));
        list.set(loc, temp);

        map.put(list.get(loc), loc);
        map.put(list.get(pointer), pointer);
    }


}

public class Question11 {
}
