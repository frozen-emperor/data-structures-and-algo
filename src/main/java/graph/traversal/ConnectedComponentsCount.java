package graph.traversal;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentsCount {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.of(
                1,List.of(2),
                2,List.of(1),
                3,List.of(),
                4,List.of(6),
                5,List.of(6),
                6,List.of(4,5,7,8),
                7,List.of(6),
                8,List.of(6)
        );

        System.out.println(connectedCompCount(graph));
    }

    private static int connectedCompCount(Map<Integer, List<Integer>> graph) {
        int count = 0;

        Set<Integer> visited = new HashSet<>();

        for(int i : graph.keySet()){
            if(explore(graph, i, visited)){
                count++;
            }
        }

        return count;
    }

    private static boolean explore(Map<Integer, List<Integer>> graph, int i, Set<Integer> visited) {

        if(visited.contains(i))
            return false;

        visited.add(i);
        for (int neighbour : graph.get(i)){
            explore(graph, neighbour, visited);
        }

        return true;
    }
}
