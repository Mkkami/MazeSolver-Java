/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.stream.events.EndElement;

public class MazeTxtReader {
    private int height = 0;
    private int width = 0;
    
    private char [][] maze;
        
    private MyPoint startPoint;     //if doesn't exist -> null
    private MyPoint exitPoint;
    
    private File file;
    
    public MazeTxtReader(File file) {
        this.file = file;
        readSize();
        
        maze = new char[height][width];
        readMaze();

    }
    private void readSize() {
        try {
            Scanner scanner = new Scanner(file);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                height++;
                width = line.length();
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    private void readMaze() {
        try {
            Scanner scanner = new Scanner(file);
            int h = 0;
            while (scanner.hasNextLine()) {
                char[] dataline = scanner.nextLine().toCharArray();
                for (int i = 0; i < width; i++) {
                    maze[h][i] = dataline[i];
                    if (dataline[i] == MazeData.START) {
                        startPoint = new MyPoint(i, h);
                    } else if (dataline[i] == MazeData.EXIT) {
                        exitPoint = new MyPoint(i, h);
                    }
                }
                h++;
            }
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
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
    
    public MyPoint getStartPoint() {
        return startPoint;
    }
    
    public MyPoint getExitPoint() {
        return exitPoint;
    }
}
