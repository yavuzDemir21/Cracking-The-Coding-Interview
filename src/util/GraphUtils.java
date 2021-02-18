package util;

import structures.GraphNode;

import java.util.HashMap;

public class GraphUtils {
    public static HashMap<Integer, GraphNode> createDirectedGraph(boolean[][] matrix){
        HashMap<Integer, GraphNode> map = new HashMap<>();

        for(int i=0; i<matrix.length; i++) map.put(i, new GraphNode(i));

        for(int i=0; i<matrix.length; i++){
            GraphNode node = map.get(i);
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j])
                    node.dependencies.add(map.get(j));
            }
        }

        return map;
    }
}
