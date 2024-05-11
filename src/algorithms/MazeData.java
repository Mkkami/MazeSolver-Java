
package algorithms;

import java.io.File;

public class MazeData {
        //test values
    private int height= 100;
    private int width= 100;
    private char [][] maze;
    
    private MazeTxtReader txtReader;
    
    public static final char EXIT = 'K';
    public static final char START = 'P';
    public static final char WALL = 'X';
    public static final char PATH = ' ';

        //test
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
        
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell);
            }
                System.out.println(); // Add a newline after printing each row
        }   

    }
    
//    private int [][] txtToMaze(File file) {
//    
//    }
    
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
