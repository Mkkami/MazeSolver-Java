/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package terminal;

import data.*;
import java.io.File;
import java.util.Scanner;

public class Terminal {
    
    private File mazeFile;
    
    private MazeData md;
    
    public Terminal() {
        readFileFromUser();
        md = new MazeData(mazeFile, false);
        md.printMaze();
    
    }
    
    private File readFileFromUser() {
        System.out.print("Input file from maze_files: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        mazeFile = new File( "src/maze_files/"+filename);
        
        if (mazeFile.exists() && mazeFile.isFile()) {
            System.out.println("file read");
        } else {
            System.out.println("file not read :(");
        }
        
        return mazeFile;
    }
    
    public File getFile() {
        return mazeFile;
    }
    
    public static void main(String[] args) {
        new Terminal();
    }
}
