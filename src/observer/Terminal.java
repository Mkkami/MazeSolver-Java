/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package observer;

import data.MazeData;
import data.Point;
import gui.GUI;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import solver.Bfs;

public class Terminal implements Observer{

    Scanner scanner = new Scanner(System.in);
    private MazeData mazeData;
    
    private boolean fileRead = false;
    
    public Terminal() {
        readCommands();
    }
    
    public void readCommands() {
        System.out.println("Terminal mode");
        while (true) {
            String command = scanner.nextLine();
            
            if (command.equalsIgnoreCase("file")) {
                System.out.print("Enter filename: ");
                String filename = scanner.nextLine();
                processFile(filename);
            } else if (command.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else if (command.equalsIgnoreCase("solve")) {
                if (fileRead) {
                    Bfs b = new Bfs();
                    List<Point> output = b.solve();
                    for (Point p : output) {
                        System.out.println(p);
                    }
                } else {
                    System.out.println("Cannot solve a maze without a file. Try 'file'.");
                }
            } else if (command.equalsIgnoreCase("show")) {
                showGUI();
            } else {
                System.out.println(command + " command does not exist. Use 'file' or 'exit'.");
            }
            
        }
        
    }
    
    private void showGUI() {
        if (mazeData == null) {
            System.out.println("No maze. Try 'file'.");
            return;
        }
        SwingUtilities.invokeLater(() -> {
            new GUI(mazeData);
        });
    }
    
    private void processFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println(filename +" file not found.");
            return;
        }
        fileRead = true;
        mazeData = new MazeData(file, filename.endsWith(".bin"));
        mazeData.addObserver(this);
        mazeData.notifyObservers();
    }
    
    
    @Override
    public void update(String filename) {
        System.out.println("Maze read from file: " + filename);
        MazeData.printMaze();
    }

}
