package graph.leetcode;

import java.util.*;

/*
* https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/3099885/day-26-simple-bfs-easiest-beginner-friendly-solution/?envType=problem-list-v2&envId=graph
* */
public class CheapestFlightsWithKStops {
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        Map<Integer, List<Stop>> graph = createAdjacencyList(flights);
        System.out.println(graph);

        //System.out.println(minFlights(graph, src, dst, k+1));


        n = 3; src = 0; dst = 2; k = 1;
        flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        graph = createAdjacencyList(flights);
        System.out.println(graph);

        //System.out.println(minFlights(graph, src, dst, k+1));

        n = 4; src = 3; dst = 0; k = 3;
        flights = new int[][]{{0,3,59}, {2,0,83}, {2,3,32}, {0,2,97}, {3,1,16}, {1,3,16}};
        graph = createAdjacencyList(flights);
        System.out.println(graph);

        System.out.println(minFlights(graph, src, dst, k+1));
    }

    private static int minFlights(Map<Integer, List<Stop>> graph, int src, int dst, int k) {
        Queue<Stop> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        int solution = Integer.MAX_VALUE;

        if(src==dst)
            return 0;

        List<Stop> c = graph.get(src);

        for(Stop s:c){
            s.nth = 1;
        }
        queue.addAll(c);
        System.out.println(queue);

        while(queue.size() > 0){

            Stop curr = queue.poll();

            if(!visited.contains(curr.dest) || curr.price <= solution) {
                visited.add(curr.dest);

                if (curr.dest == dst && curr.nth <= k) {
                    solution = Math.min(solution, curr.price);
                }

                if (graph.containsKey(curr.dest)) {
                    for (Stop stop : graph.get(curr.dest)) {

                        queue.add(Stop.of(stop.dest, stop.price + curr.price, curr.nth + 1));
                    }
                }
            }
            System.out.println(queue);
        }
        return solution == Integer.MAX_VALUE ? -1 : solution;
    }

    private static Map<Integer, List<Stop>> createAdjacencyList(int[][] flights) {
        Map<Integer, List<Stop>> graph = new HashMap<>();

        for(int[] route:flights){
            List<Stop> stops;

            if(graph.containsKey(route[0])){
                stops = graph.get(route[0]);
            }else{
                stops = new ArrayList<>();
            }

            stops.add(Stop.of(route[1], route[2]));
            graph.put(route[0], stops);
        }
        return graph;
    }
}
class Stop{
    int dest;
    int price;

    int nth;

    private Stop(int dest, int price) {
        this.dest = dest;
        this.price = price;
    }

    static Stop  of(int dest, int price) {
        return new Stop(dest, price);
    }

    static Stop  of(int dest, int price,int nth) {
        Stop stop = new Stop(dest, price);
        stop.nth = nth;
        return stop;
    }

    public int dest() {
        return this.dest;
    }

    public int price() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "dest=" + dest +
                ", price=" + price +
                ", nth=" + nth +
                '}';
    }
}
