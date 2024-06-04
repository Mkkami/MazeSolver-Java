/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import gui.GUI;
import javax.swing.SwingUtilities;
import observer.Terminal;

public class Main {
    public static void main(String [] args) {
        if (args.length == 1) {
            new Terminal(args[0]);
        }
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
        });
    }
}
