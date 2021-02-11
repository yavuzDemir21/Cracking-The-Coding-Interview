package structures;

import java.util.ArrayList;

public class GraphNode {
    public int val;
    public ArrayList<GraphNode> neighbours;
    public GraphNode(int val){
        this.val = val;
        neighbours = new ArrayList<>();
    }
}
