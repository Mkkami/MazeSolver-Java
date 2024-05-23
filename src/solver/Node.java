/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package solver;

public class Node {
    private final int x;
    private final int y;
    private final Node previous;

    public Node(int x, int y, Node previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Node getPrevious() {
        return previous;
    } 
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
