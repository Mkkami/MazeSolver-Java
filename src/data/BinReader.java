/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.font.TextAttribute;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HexFormat;

public class BinReader implements FileReader {

    private int height = 0;
    private int width = 0;

    private char[][] maze;

    private Point startPoint;     //if doesn't exist -> null
    private Point exitPoint;

    private File file;

    public BinReader(File file) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int fileID = Integer.reverseBytes(in.readInt());
            byte escape = in.readByte();
            width = Short.reverseBytes(in.readShort());
            height = Short.reverseBytes(in.readShort());
            short startX = Short.reverseBytes(in.readShort());
            short startY = Short.reverseBytes(in.readShort());
            short exitX = Short.reverseBytes(in.readShort());
            short exitY = Short.reverseBytes(in.readShort());
            byte[] reserved = new byte[12];
            in.readFully(reserved);
            int counter = Integer.reverseBytes(in.readInt());
            int solution_offset = Integer.reverseBytes(in.readInt());
            byte separator = in.readByte();
            byte wall = in.readByte();
            byte path = in.readByte();

            startX--;
            startY--;
            exitX--;
            exitY--;
            
            if (startX >= 0 && startY >= 0) {
                startPoint = new Point(startX, startY);
            }
            if (exitX >= 0 && exitY >= 0) {
                exitPoint = new Point(exitX, exitY);
            }
            
            maze = new char[height][width];
            int total = 0;
            int check = 0;
            for (int i = 0; i < counter; i++) {

                byte sep = in.readByte();
                byte val = in.readByte();
                int count = in.readUnsignedByte();
                
                for (int j = 0; j < count+1; j++) {
                    int x = total % width;
                    int y = total / width;
                    
                    total++;

                    if (val == path) {
                        maze[y][x] = ' ';
                    } else if (val == wall) {
                        maze[y][x] = 'X';
                    }
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public char[][] getMaze() {
        return maze;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public Point getExitPoint() {
        return exitPoint;
    }

    public static void main(String[] args) {

        File file = new File("maze_files/maze.bin");
//        new MazeData(file, true);
        BinReader br = new BinReader(file);
        for (char [] row: br.maze) {
            System.out.println(new String(row));
        }
    }
}
