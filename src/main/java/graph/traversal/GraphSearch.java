package graph.traversal;

import java.util.*;

public class GraphSearch {
    /***
     *      a -> c
     *      ↓    ↓
     *      b    e
     *      ↓
     *      d -> f
     */
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = Map.of(
                'a',List.of('b','c'),
                'b',List.of('d'),
                'c',List.of('e'),
                'd',List.of('f'),
                'e',List.of(),
                'f',List.of()
        );

        System.out.println("DFS using stack");
        // a,c,e,b,d,f
        printDFS(graph, 'a');

        System.out.println("\nDFS using recursion");
        // a,c,e,b,d,f
        printDFSRecursive(graph, 'a');

        System.out.println("\nBFS using queue");
        // a, b, c, d, e, f
        printBFS(graph, 'a');
    }


    private static void printBFS(Map<Character, List<Character>> graph, char start) {
        Queue<Character> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()){
            char current = queue.poll();

            System.out.print(current);
            System.out.print(",");
            List<Character> neighbours = graph.get(current);
            for(char c: neighbours)
                queue.add(c);
        }
    }

    private static void printDFS(Map<Character, List<Character>> graph, char start) {
        Stack<Character> stack = new Stack<>();
        stack.push(start);

        while(!stack.empty()){
            char current = stack.pop();

            System.out.print(current);
            System.out.print(",");
            List<Character> neighbours = graph.get(current);
            for(char c: neighbours)
                stack.push(c);
        }
    }


    private static void printDFSRecursive(Map<Character, List<Character>> graph, char start) {
        System.out.print(start);
        System.out.print(",");

        List<Character> neighbours = graph.get(start);
        for(int i = neighbours.size() - 1; i > -1; i--)
            printDFSRecursive(graph,neighbours.get(i));
    }
}
