
package algorithms;

import java.io.File;

public class MazeData {
    private int height;
    private int width;
    private char [][] maze;
    
    public static final char EXIT = 'K';
    public static final char START = 'P';
    public static final char WALL = 'X';
    public static final char PATH = ' ';
    
    private MazeTxtReader txtReader;

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
    
    
    public char [][] getMaze() {
        return maze;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
