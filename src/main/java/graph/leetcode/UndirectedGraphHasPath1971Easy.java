package graph.leetcode;

import java.util.*;

public class UndirectedGraphHasPath1971Easy {

    public static void main(String[] args) {
        // n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2

        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("src=0 dest=2 : " + hasUndirectedPath(edges, 0, 2));
    }

    private static boolean hasUndirectedPath(int[][] edges, int src, int dest) {
        Map<Integer, List<Integer>> adjacencyList = buildGraph(edges);
        System.out.println(adjacencyList);

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(src);
        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited.contains(current)) {
                if (current == dest)
                    return true;

                for (int c : adjacencyList.get(current)) {
                    stack.push(c);
                }

                visited.add(current);
            }

        }
        return false;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());

            if (!graph.containsKey(edge[1]))
                graph.put(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
