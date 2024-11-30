package graph.leetcode;

import java.util.*;

public class CourseSchedule_incomp {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

        prerequisites = new int[][]{
                {1, 0},
                {0, 1}
        };

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

        prerequisites = new int[][]
                {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        System.out.println(Arrays.toString(findOrder(20, prerequisites)));

        prerequisites = new int[][]
                {{1,4}, {2,4}, {3,1}, {3,2}};
        System.out.println(Arrays.toString(findOrder(5, prerequisites)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) {
            int[] arr = new int[numCourses];

            for(int i=0;i<numCourses;i++)
                arr[i] = i;

            return arr;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pr : prerequisites) {
            if (graph.containsKey(pr[0])) {
                List<Integer> required = graph.get(pr[0]);
                required.add(pr[1]);

                graph.put(pr[0], required);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pr[1]);
                graph.put(pr[0], list);
            }
        }

        System.out.println(graph);
        return dfs(numCourses, graph, new HashSet<>());
    }

    private static int[] dfs(int n, Map<Integer, List<Integer>> graph, HashSet<Integer> visited) {
        Set<Integer> done = new HashSet<>();
        Deque<Integer> order = new ArrayDeque<>();
        for(int i:graph.keySet()){
            if(checkCycle(graph, i, graph.get(i), new HashSet<>(), order, done))
                return new int[]{};
            else {
                if(!done.contains(i)){
                    order.add(i);
                    done.add(i);
                }

                graph.put(i, List.of());
            }
        }

        for(int i=0;i<n;i++){
            if(!done.contains(i)){
                order.addFirst(i);
            }
        }

        int[] arr =  new int[order.size()];
        int index=0;
        for(int i:order){
            arr[index++] = i;
        }
        return arr;
    }

    private static boolean checkCycle(Map<Integer, List<Integer>> graph, int course, List<Integer> integers, HashSet<Integer> visited,Queue<Integer> order,Set<Integer> done) {

        boolean cycle = false;
        for(int i:integers){
            if(i == course || visited.contains(i))
                return true;
            else if(graph.get(i) != null){
                visited.add(i);
                cycle  =cycle || checkCycle(graph, course, graph.get(i), visited, order, done);

                if(!cycle){
                    visited.remove(i);
                    if(!done.contains(i)){
                        order.add(i);
                        done.add(i);
                    }
                }
            }
            else if(graph.get(i) == null && !done.contains(i)){
                order.add(i);
                done.add(i);
            }
        }
        return cycle;
    }
}
