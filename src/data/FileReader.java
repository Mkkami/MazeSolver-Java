/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

/**
 *
 * @author micha
 */
public interface FileReader {
    char[][] getMaze();
    int getHeight();
    int getWidth();
    Point getStartPoint();
    Point getExitPoint();
}
