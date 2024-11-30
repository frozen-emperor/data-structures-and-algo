package graph.grid;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class KnightProblem {
    
    public static void main(String[] args) {

        // can the knight travel from src to dest
        // knight position is i,j
        System.out.println("from (1,3) -> (5,0) : " + canTravel(grid(), 1 ,3, 5, 0));
        System.out.println("from (1,3) -> (-1,3) : " + canTravel(grid(), 1 ,3, -1, 3));
        System.out.println("from (1,3) -> (5,5) : " + canTravel(grid(), 1 ,3, 5, 5));
        System.out.println("from (1,3) -> (1,3) : " + canTravel(grid() ,1 ,3, 1, 3));
        System.out.println("from (1,3) -> (3,2) : " + canTravel(grid(), 1 ,3, 3, 2));
        System.out.println("from (1,3) -> (8,7) : " + canTravel(grid(), 1 ,3, 8, 7));

        // number of steps needed to travel from src to destination
        // knight position is i,j
//        System.out.println("from (1,3) -> (5,0)" + canTravel(grid(), 1 ,3, 5, 0));
    }

    private static int[][] grid() {
        return new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
    }

    private static int canTravel(int[][] grid, int i, int j, int destI, int destJ) {
        Queue<KnightPos> queue = new ArrayDeque<>();

        queue.add(KnightPos.of(i,j, 0));
//        Integer.MAX_VALUE
        while(queue.size() > 0){
            KnightPos curr = queue.poll();
            int currI = curr.i(), currJ = curr.j();

            if((currI > -1 && currI < grid.length) && (currJ > -1 && currJ < grid[currI].length) && (currI == destI && currJ == destJ)) {
                //System.out.println(queue.size());
                //System.out.println("steps : "+curr.dis());
                return curr.dis();
            }

            //check visited
            if((currI > -1 && currI < grid.length) && (currJ > -1 && currJ < grid[currI].length) && grid[currI][currJ] == 0){

                queue.add(KnightPos.of(currI - 1, currJ - 2, curr.dis() + 1));
                queue.add(KnightPos.of(currI - 1, currJ + 2, curr.dis() + 1));
                queue.add(KnightPos.of(currI - 2, currJ - 1, curr.dis() + 1));
                queue.add(KnightPos.of(currI - 2, currJ + 1, curr.dis() + 1));

                queue.add(KnightPos.of(currI + 1, currJ - 2, curr.dis() + 1));
                queue.add(KnightPos.of(currI + 1, currJ + 2, curr.dis() + 1));
                queue.add(KnightPos.of(currI + 2, currJ - 1, curr.dis() + 1));
                queue.add(KnightPos.of(currI + 2, currJ + 1, curr.dis() + 1));

                // mark visited
                grid[currI][currJ] = 1;
            }
        }
        return -1;
    }
}
class KnightPos{
    private int i, j, dis;

    private KnightPos(int i, int j, int dis) {
        this.i=i;
        this.j=j;
        this.dis = dis;
    }

    public static KnightPos of(int i, int j,int dis){
        return new KnightPos(i,j, dis);
    }

    public int  i() {
        return i;
    }

    public int  j() {
        return j;
    }

    public int dis() {
        return this.dis;
    }
}
