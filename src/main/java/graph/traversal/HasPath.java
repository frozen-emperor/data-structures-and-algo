package graph.traversal;

import java.util.List;
import java.util.Map;

public class HasPath {

    /*
    *  f -> g -> h
    *  ↓  ↗
    *  i  <- j
    *  ↓
    *  k
    */
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = Map.of(
                'f', List.of('i','g'),
                'g', List.of('h'),
                'h', List.of(),
                'i', List.of('k','g'),
                'j', List.of('i'),
                'k', List.of()
        );
        System.out.println("src=f dest=k " + hasPath(graph,'f','k'));
        System.out.println("src=f dest=f " + hasPath(graph,'f','f'));
        System.out.println("src=j dest=k " + hasPath(graph,'j','k'));
        System.out.println("src=j dest=g " + hasPath(graph,'j','g'));
        System.out.println("src=j dest=f " + hasPath(graph,'j','f'));
    }

    private static boolean hasPath(Map<Character, List<Character>> graph, char src, char dest) {
        if(src == dest)
            return true;

        for(char c: graph.get(src))
            if(hasPath(graph,c,dest))
                return true;

        return false;
    }
}
