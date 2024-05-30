
package data;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import observer.Subject;

public class MazeData implements Subject{
    private static int height;
    private static int width;
    private static char [][] maze;
    
    public static final char EXIT = 'K';
    public static final char START = 'P';
    public static final char WALL = 'X';
    public static final char PATH = ' ';
    
    public static Point startPoint;
    public static Point exitPoint;
    
    private static FileReader fileReader;
    
    private List<Observer> observers = new ArrayList<>();

    public MazeData(File file, boolean isBin) {
        if (isBin) {
            fileReader = new BinReader(file);
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
        if (startPoint != null)
            
            if (newStart.equals(exitPoint)) {
                exitPoint = null;
            }
        startPoint = newStart;
    }
    
    public static void changeExitPoint(Point newExit) {
        exitPoint = newExit;
        if (startPoint.equals(exitPoint)) {
            startPoint = null;
        }
    }
    
    public static Color getCellTypeColor(int x, int y) {
        switch (maze[y][x]) {
            case 'X':
                return Color.BLACK;
            case ' ':
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
    }
    
    public static Color getCellTypeColor(Point p) {
        switch (maze[p.getY()][p.getX()]) {
             case 'X':
                return Color.BLACK;
            case ' ':
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(fileReader.getFilename());
        }
    }
}
