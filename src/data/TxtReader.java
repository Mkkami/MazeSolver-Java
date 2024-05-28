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

public class TxtReader implements FileReader{
    private int height = 0;
    private int width = 0;
    
    private char [][] maze;
        
    private Point startPoint;     //if doesn't exist -> null
    private Point exitPoint;
    
    private File file;
    
    public TxtReader(File file) {
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
                    if (dataline[i] == MazeData.START) {
                        startPoint = new Point(i, h);
                        maze[h][i] = 'X';
                    } else if (dataline[i] == MazeData.EXIT) {
                        exitPoint = new Point(i, h);
                        maze[h][i] = 'X';
                    } else {
                        maze[h][i] = dataline[i];
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
    
    public Point getStartPoint() {
        return startPoint;
    }
    
    public Point getExitPoint() {
        return exitPoint;
    }
}
