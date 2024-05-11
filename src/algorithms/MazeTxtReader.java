/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package algorithms;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.stream.events.EndElement;

public class MazeTxtReader {
    private int height = 0;
    private int width = 0;
    
    private char [][] maze;
    
    
    public MazeTxtReader(File file) {
        try {
            Scanner scannersize = new Scanner(file);
            String line;
            while (scannersize.hasNextLine()) {
                line = scannersize.nextLine();
                height++;
                width = line.length();
            }
            System.out.println(height + ", " + width);
            maze = new char[height][width];
            scannersize.close();
            Scanner scannerdata = new Scanner(file);
            int h = 0;
            while (scannerdata.hasNextLine()) {
                char[] dataline = scannerdata.nextLine().toCharArray();
                for (int i = 0; i < width; i++) {
                    maze[h][i] = dataline[i];
                }
                h++;
            }
            
            for (char[]cc:maze) {
                for (char c : cc) {
                    System.out.print(c);
                }
                System.out.println();
            }
            
        } catch (IOException ex) {
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
}
