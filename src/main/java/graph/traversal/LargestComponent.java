package graph.traversal;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestComponent {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        );

        System.out.println(largestComponent(graph));
    }

    private static int largestComponent(Map<Integer, List<Integer>> graph) {
        int largest = 0;

        Set<Integer> visited = new HashSet<>();
        for(int node:graph.keySet()){
            int dfsCount = dfs(graph, node, visited);
            if(dfsCount > largest)
                largest = dfsCount;
        }
        return largest;
    }

    private static int dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if(visited.contains(node))
            return 0;

        visited.add(node);

        int count = 1;
        for (int neighbour:graph.get(node)){
            count += dfs(graph,neighbour,visited);
        }

        return count;
    }
}
