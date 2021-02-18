package treesandgraphs;

import structures.GraphNode;

import java.util.*;

/*
You are given a list of projects and a list of dependencies (which is a list of pairs of projects,where the second
project is dependent on the first project).All of a project's dependencies must be built before the project is. Find a
build order that will allow the projects to be built. If there is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output:
f, e, a, b, d, c

 */
public class Question7 {

    public static void main(String[] args) {

        String[] projects = {"a","b","c","d","e","f"};
        ArrayList<String[]> dependencies = new ArrayList<>();
        dependencies.add(new String[]{"a", "d"});
        dependencies.add(new String[]{"f", "b"});
        dependencies.add(new String[]{"b", "d"});
        dependencies.add(new String[]{"f", "a"});
        dependencies.add(new String[]{"d", "c"});
        //dependencies.add(new String[]{"c", "a"});

        ArrayList<String> result = buildOrder(projects, dependencies);

        result.forEach(x -> System.out.print(x + " "));


    }

    static HashMap<String, GraphNode> map = new HashMap<>();

    private static ArrayList<String> buildOrder(String[] projects, ArrayList<String[]> dependencies){

        HashMap<String, HashSet<String>> dependencyChecker = new HashMap<>();
        HashMap<String, Integer> cycleChecker = new HashMap<>();
        for(String s : projects){
            map.put(s, new GraphNode(s));
            dependencyChecker.put(s, new HashSet<>());
            cycleChecker.put(s, 0);
        }

        createGraph(dependencies);

        ArrayList<GraphNode> unboundedProjects = findUnboundedProjects();

        Queue<GraphNode> queue = new LinkedList<>(unboundedProjects);

        ArrayList<String> schedule = new ArrayList<>();
        HashSet<GraphNode> visited = new HashSet<>(unboundedProjects);


        while(!queue.isEmpty()){

            GraphNode cur = queue.remove();

            if(cur.dependencies.size() == dependencyChecker.get(cur.key).size()){

                schedule.add(cur.key);
                for(GraphNode dependent : cur.dependents){
                    dependencyChecker.get(dependent.key).add(cur.key);
                    if(!visited.contains(dependent)){
                        visited.add(dependent);
                        queue.add(dependent);
                    }
                }
            }else{
                if(cycleChecker.get(cur.key) == schedule.size()){
                    System.out.println("Cycle Detected");
                    return new ArrayList<>();
                }
                cycleChecker.put(cur.key, schedule.size());
                queue.add(cur);
            }
        }

        return schedule;

    }

    private static ArrayList<GraphNode> findUnboundedProjects() {
        ArrayList<GraphNode> projects = new ArrayList<>();

        for(String key : map.keySet()){
            if(map.get(key).dependencies.isEmpty()) projects.add(map.get(key));
        }

        return projects;
    }

    public static void createGraph(ArrayList<String[]> dependencies){
        for(String[] pair : dependencies){
            GraphNode dependency = map.get(pair[0]);
            GraphNode dependent = map.get(pair[1]);

            dependency.dependents.add(dependent);
            dependent.dependencies.add(dependency);
        }
    }


}
