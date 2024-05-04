/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class MazeFileReader {
    
    public int [] readMazeSize(File file) throws FileNotFoundException {
        int [] size = new int[2];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                size[0] = line.length();
                size[1]++;
            }
            return size;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
}
