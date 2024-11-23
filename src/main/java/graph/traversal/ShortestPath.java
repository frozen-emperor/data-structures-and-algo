package graph.traversal;

import java.util.*;

public class ShortestPath {
    /*
     *    x  y
     * w        z
     *     v
     *
     * a - b
     */
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = Map.of(
                'w', List.of('x', 'v'),
                'x',List.of('w','y'),
                'y',List.of('x','z'),
                'v',List.of('w','z'),
                'z',List.of('y','v'),
                'a',List.of('b'),
                'b',List.of('a')
        );

        //exists
        System.out.println(shortestPath(graph, 'w', 'z'));

        // not exists
        System.out.println(shortestPath(graph, 'w', 'a'));
    }

    private static int shortestPath(Map<Character, List<Character>> graph, char src, char dest) {

        Queue<CurrentNode> queue = new ArrayDeque<>();
        Set<Character> visited = new HashSet<>();

//        int shortest = Integer.MAX_VALUE;

        queue.add(CurrentNode.of(src, 0));

        while(!queue.isEmpty()){

            CurrentNode currentNode = queue.poll();
            char curr = currentNode.getCurr();
            int count = currentNode.getPathCount();

            if(curr == dest)
                return count;

            for(char neighbour : graph.get(curr)){
                if(!visited.contains(neighbour)) {
                    queue.add(CurrentNode.of(neighbour, count + 1));
                    visited.add(neighbour);
                }
            }
        }
        return -1;
    }
}

class CurrentNode{

    private char curr;

    private int pathCount;

    CurrentNode(char curr, int pathCount){
        this.curr = curr;
        this.pathCount = pathCount;
    }

    public char getCurr() {
        return curr;
    }

    public int getPathCount() {
        return pathCount;
    }

    static CurrentNode of(char curr, int pathCount){
        return new CurrentNode(curr, pathCount);
    }
}
