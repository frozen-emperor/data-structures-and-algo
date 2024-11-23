package graph.traversal;

import java.util.*;

public class UndirectedGraphHasPath {
    public static void main(String[] args) {
        char[][] edges = {
                {'i','j'},
                {'k','i'},
                {'m','k'},
                {'k','l'},
                {'o','n'}
        };

        System.out.println("src=j dest=m : " + hasUndirectedPath(edges,'j','m'));
        System.out.println("src=j dest=o : " + hasUndirectedPath(edges,'j','o'));
        System.out.println("src=n dest=o : " + hasUndirectedPath(edges,'n','o'));
    }

    private static boolean hasUndirectedPath(char[][] edges, char src, char dest) {
        Map<Character, List<Character>> adjacencyList = buildGraph(edges);
        System.out.println(adjacencyList);

        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();

        stack.push(src);
        while(!stack.isEmpty()){
            char current = stack.pop();

            if(!visited.contains(current)) {
                if (current == dest)
                    return true;

                for(char c : adjacencyList.get(current)){
                    stack.push(c);
                }

                visited.add(current);
            }

        }
        return false;
    }

    private static Map<Character, List<Character>> buildGraph(char[][] edges) {
        Map<Character,List<Character>> graph = new HashMap<>();

        for(char[] edge:edges){
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0],new ArrayList<>());

            if(!graph.containsKey(edge[1]))
                graph.put(edge[1],new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
