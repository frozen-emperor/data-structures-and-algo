package graph.grid;

import java.util.HashSet;
import java.util.Set;

public class IslandCount {
     static char W = 'W', L = 'L';
    public static void main(String[] args) {
        char[][] grid = {
                {W, L, W, W, L, W},
                {L, L, W, W, L, W},
                {W, L, W, W, W, W},
                {W, W, W, L, L, W},
                {W, L, W, L, L, W},
                {W, W, W, W, W, W},
        };

        System.out.println(countIslands(grid));
    }

    private static int countIslands(char[][] grid) {
        int islandCount = 0;
        Set<String> visited = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(!visited.contains(String.valueOf(i)+String.valueOf(j)) && grid[i][j] == L){
                    islandCount++;

                    depthFirstSearch(grid, i , j, visited);

                    visited.add(String.valueOf(i)+String.valueOf(j));
                }
            }
        }

        return islandCount;
    }

    private static void depthFirstSearch(char[][] grid, int i, int j, Set<String> visited) {
        if(visited.contains(String.valueOf(i)+String.valueOf(j)) || i < 0 || j <0 || i>=grid.length || j>=grid[i].length)
            return;

        visited.add(String.valueOf(i)+String.valueOf(j));

        if(grid[i][j] == W){
            return;
        }

        depthFirstSearch(grid, i-1, j,visited);
        depthFirstSearch(grid, i+1, j,visited);
        depthFirstSearch(grid, i, j-1,visited);
        depthFirstSearch(grid, i, j+1,visited);

    }
}
