package treesandgraphs;

import structures.GraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static util.GraphUtils.createDirectedGraph;

/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
*/
public class Question1 {
    public static void main(String[] args) {

        boolean[][] matrix = {{false, true, true, false, false,false,false},
                {false, false, false, true, true,false,false},
                {false, false, false, false, false,true,true},
                {false, false, false, false, false,false,false},
                {false, false, false, false, false,false,false},
                {false, false, false, false, false,false,false},
                {false, false, false, false, false,false,false}};

        HashMap<Integer, GraphNode> map = createDirectedGraph(matrix);

        System.out.println(isConnected(map.get(0), map.get(6)));
        System.out.println(isConnected(map.get(2), map.get(6)));
        System.out.println(isConnected(map.get(1), map.get(6)));

    }


    private static boolean isConnected(GraphNode gNode1, GraphNode gNode2) {

        if (gNode1.val == gNode2.val) return true;

        HashSet<Integer> visited = new HashSet<>();

        Queue<GraphNode> qu = new LinkedList<>();

        qu.add(gNode1);
        visited.add(gNode1.val);

        while (!qu.isEmpty()) {
            GraphNode cur = qu.remove();

            for (GraphNode child : cur.dependencies) {
                if (!visited.contains(child.val)) {
                    if (child.val == gNode2.val) return true;
                    qu.add(child);
                    visited.add(child.val);
                }
            }
        }

        return false;
    }

}
