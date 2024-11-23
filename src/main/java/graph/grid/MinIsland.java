package graph.grid;

import java.util.HashSet;
import java.util.Set;

public class MinIsland {
     static char W = 'W', L = 'L';
    public static void main(String[] args) {
        char[][] grid = {
                {W, L, W, W, L, W},
                {L, L, W, W, L, L},
                {W, L, W, W, W, W},
                {W, W, W, L, L, W},
                {W, L, L, L, L, W},
                {W, L, W, W, W, W},
        };

        System.out.println(countIslands(grid));
    }

    private static int countIslands(char[][] grid) {
        int min = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(!visited.contains(String.valueOf(i)+String.valueOf(j)) && grid[i][j] == L){

                    int curr = depthFirstSearch(grid, i , j, visited);
                    min = curr > min ? min : curr;

                    visited.add(String.valueOf(i)+String.valueOf(j));
                }
            }
        }

        return min;
    }

    private static int depthFirstSearch(char[][] grid, int i, int j, Set<String> visited) {
        if(visited.contains(String.valueOf(i)+String.valueOf(j)) || i < 0 || j <0 || i>=grid.length || j>=grid[i].length)
            return 0;

        visited.add(String.valueOf(i)+String.valueOf(j));

        if(grid[i][j] == W){
            return 0;
        }

        return 1 + depthFirstSearch(grid, i-1, j,visited) +
        depthFirstSearch(grid, i+1, j,visited) +
        depthFirstSearch(grid, i, j-1,visited) +
        depthFirstSearch(grid, i, j+1,visited);

    }
}
