import java.util.LinkedList;
import java.util.Queue;

public class AreaOfMaxIslands {
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //int noOfIslands = 0;
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            //int area = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //noOfIslands++;
                    grid[i][j] = 0;
                    int area = bfs(grid, i, j, m, n, 1);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return (maxArea == Integer.MIN_VALUE) ? 0 : maxArea ;
    }

    public static int bfs(int[][] grid, int r, int c, int rows, int cols, int area) {
        Queue<int[]> connected = new LinkedList<>();
        connected.offer(new int[]{r, c});

        while (!connected.isEmpty()) {
            int[] polled = connected.poll();
            for (int[] dir : dirs) {
                int nr = polled[0] + dir[0];
                int nc = polled[1] + dir[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                    area++;
                    grid[nr][nc] = 0;
                    connected.offer(new int[]{nr, nc});
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] islandCombination = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println("Area of max island is " + maxAreaOfIsland(islandCombination));
    }
}