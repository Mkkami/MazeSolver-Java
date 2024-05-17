
package data;

import java.io.File;

public class MazeData {
    private static int height;
    private static int width;
    private static char [][] maze;
    
    public static final char EXIT = 'K';
    public static final char START = 'P';
    public static final char WALL = 'X';
    public static final char PATH = ' ';
    
    private char prev_x = 'X';
    private char prev_y = 'X';
    
    private MazeTxtReader txtReader;
    private MazeBinReader binReader;

    public MazeData(File file, boolean isBin) {
        if (isBin) {
            //change from bin to maze
            // another class for reading bin files
        } else {
            txtReader = new MazeTxtReader(file);
            height = txtReader.getHeight();
            width = txtReader.getWidth();
            maze = txtReader.getMaze();
        }
    }
    public static boolean isCorner(int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        } else if (x == 0 && y == height-1) {
            return true;
        } else if (x == width-1 && y == 0) {
            return true;
        } else if (x == width-1 && y == height-1) {
            return true;
        }
        return false;
    }
    
    public static boolean isInMazeBounds(int x, int y) {
        if(x < width && y < height)
            return true;
        return false;
    }
    
    public static void printMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
    
    public static char [][] getMaze() {
        return maze;
    }

    public static int getHeight() {
        return height;
    }
    public static int getWidth() {
        return width;
    }
}
