package graph.grid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {


    public static void main(String[] args) {
        // not optimal but works on leetcode

        //much simpler intuition would be check all the margin O's and the O's connected
        // to them. everything else apart from these would be surrounded eventually

        char[][] grid = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','X','X'},
                {'X','O','O','X'}
        };
//        char[][] grid  =
//                {{'O','O','O','O','X','X'},
//                {'O','O','O','O','O','O'},
//                {'O','X','O','X','O','O'},
//                {'O','X','O','O','X','O'},
//                {'O','X','O','X','O','O'},
//                {'O','X','O','O','O','O'}};

        solve(grid);

        for(char[] arr:grid)
            System.out.println(Arrays.toString(arr));
    }

    public static void solve(char[][] board) {
        Set<String> visited = new HashSet<>();
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j< board[i].length; j++){
                if(board[i][j] == 'O' ){

                    boolean isSurround = DFS(board, i, j, new HashSet<>());
                    if(isSurround)
                        surroundAll(board, i ,j,new HashSet<>());
                }
            }
        }
    }

    private static void surroundAll(char[][] board, int i, int j, HashSet<String> visited) {
        if(!visited.contains(String.valueOf(i)+',' + j) && i > 0 && i < board.length - 1 && j > 0 && j < board[i].length - 1 && board[i][j] == 'O'){
            board[i][j] = 'X';

            visited.add(String.valueOf(i)+',' + j);
            surroundAll(board, i - 1, j, visited);
            surroundAll(board, i + 1, j, visited);
            surroundAll(board, i, j + 1, visited);
            surroundAll(board, i, j - 1, visited);
        }
    }

    private static boolean DFS(char[][] board, int i, int j, Set<String> visited) {
        if(visited.contains(String.valueOf(i)+',' + j)){
            return true;
        }
        if(board[i][j] == 'X')
            return true;

        if(i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1){
            return board[i][j] == 'X';
        }

        visited.add(String.valueOf(i)+',' + j);
        return DFS(board, i - 1, j, visited) &&
                DFS(board, i + 1, j, visited) &&
                DFS(board, i, j + 1, visited) &&
                DFS(board, i, j - 1, visited);
    }
}
