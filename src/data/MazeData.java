
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
    public static char prev_end = 'X';
    
    public static Point startPoint;
    public static Point exitPoint;
    
    private static TxtReader txtReader;
    private static BinReader binReader;
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
        startPoint = txtReader.getStartPoint();
        exitPoint = txtReader.getExitPoint();
        prev_start = 'X';
        prev_end = 'X';
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
        if (startPoint != null) {
            maze[startPoint.getY()][startPoint.getX()] = prev_start;
        }
        if (maze[newStart.getY()][newStart.getX()] != 'K')
            prev_start = maze[newStart.getY()][newStart.getX()];
        else  {
            prev_start = prev_end;
            exitPoint = null;
        }
        maze[newStart.getY()][newStart.getX()] = MazeData.START;
        startPoint = newStart;
    }
    
    public static void changeExitPoint(Point newExit) {
        if (exitPoint != null) {
            maze[exitPoint.getY()][exitPoint.getX()] = prev_end;
        }
        if (maze[newExit.getY()][newExit.getX()] != 'P')
            prev_end = maze[newExit.getY()][newExit.getX()];
        else {
            prev_end = prev_start;
            startPoint = null;
        }
        maze[newExit.getY()][newExit.getX()] = MazeData.EXIT;
        exitPoint = newExit;
    }
}
