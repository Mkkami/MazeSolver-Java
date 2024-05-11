/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String [] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
        });
    }
}
