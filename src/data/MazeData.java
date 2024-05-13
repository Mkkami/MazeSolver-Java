
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
