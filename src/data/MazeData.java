
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
    
    public static char prev_start = 'X';
    public static char prev_exit = 'X';
    
    public static Point startPoint;
    public static Point exitPoint;
    
    private static FileReader fileReader;

    public MazeData(File file, boolean isBin) {
        if (isBin) {
            fileReader = new BinReader();
        } else {
            fileReader = new TxtReader(file);

        }
        height = fileReader.getHeight();
        width = fileReader.getWidth();
        maze = fileReader.getMaze();
        startPoint = fileReader.getStartPoint();
        exitPoint = fileReader.getExitPoint();
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
    
    public static void reset() {
        Point newStart = fileReader.getStartPoint();
        Point newExit = fileReader.getExitPoint();
        changeStartPoint(newStart);
        changeExitPoint(newExit);
        prev_start = 'X';
        prev_exit = 'X';
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
    
    public static void changeStartPoint(Point newStart) {
        startPoint = newStart;
        if (startPoint.equals(exitPoint)) {
            exitPoint = null;
        }
    }
    
    public static void changeExitPoint(Point newExit) {
        exitPoint = newExit;
        if (startPoint.equals(exitPoint)) {
            startPoint = null;
        }
    }
}
