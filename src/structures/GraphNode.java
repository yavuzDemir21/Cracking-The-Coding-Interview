package structures;

import java.util.ArrayList;

public class GraphNode {
    public int val;
    public String key;
    public ArrayList<GraphNode> dependencies;
    public ArrayList<GraphNode> dependents;

    public GraphNode(int val){
        this.val = val;
        dependencies = new ArrayList<>();
        dependents = new ArrayList<>();
    }
    public GraphNode(String key){
        this.key = key;
        dependencies = new ArrayList<>();
        dependents = new ArrayList<>();
    }
}
