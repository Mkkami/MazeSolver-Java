
package algorithms;

public class MazeData {
        //test values
    private int height= 100;
    private int width= 100;
    private int [][] maze;
    
    public static final int EXIT = -2;
    public static final int START = -1;
    public static final int WALL = 1;
    public static final int PATH = 0;

        //test
    public MazeData() {
        maze = new int[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j%2 == 0)
                    maze[i][j] = WALL;
                else
                    maze[i][j] = PATH;
            }
        }
        maze[1][0] = START;
        maze[98][99] = EXIT;
    }
    
    public int [][] getMaze() {
        return maze;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
