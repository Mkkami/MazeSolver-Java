/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui.elements;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


public class FileInfoPanel {
    private final Color BackgroundColor = new Color (30, 30, 30);
    
    private JPanel infoPanel;
    private JLabel infoLabel;

    public FileInfoPanel() {
        infoPanel = new JPanel();
        infoPanel.setBackground(BackgroundColor);
        infoPanel.setPreferredSize(new Dimension(250, 150));
        infoPanel.setLayout(new BorderLayout());
        
        infoLabel = new JLabel("Input file", SwingConstants.CENTER);
        infoLabel.setFont( new Font("Tahoma", Font.PLAIN, 30));
        infoLabel.setForeground(Color.GRAY);
        infoPanel.add(infoLabel);
        
        Border border = BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED);
        infoPanel.setBorder(border);
    }
    
    public JPanel getFileInfoPanel() {
        return infoPanel;
    }
    
    public void changeFileInfoPanel(String text, Color clr) {
        infoLabel.setText(text);
        infoLabel.setForeground(clr);
    }

}
