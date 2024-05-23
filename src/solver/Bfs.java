/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package solver;
import data.MazeData;
import data.Point;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import java.lang.NullPointerException;

public class Bfs {
            //up right left down
    private final static int[][] DIRECTIONS = { {-1, 0}, {0, 1}, {0, -1}, {1, 0} };

    private char [][] maze;
    private int height = MazeData.getHeight();
    private int width = MazeData.getWidth();
    private Node startNode;
    private Node exitNode;
    private List<Node> path;
    
    private Queue<Node> queue = new LinkedList<>();
    
    private boolean [][]visited = new boolean[height][width];   // auto set to false
    
    public Bfs() {
        this.maze = MazeData.getMaze();
        
        if (MazeData.startPoint == null || MazeData.exitPoint == null) {
            throw new NullPointerException("start or end point null");
        }
        
        startNode = new Node(MazeData.startPoint.getX(), MazeData.startPoint.getY(), null);
        exitNode = new Node(MazeData.exitPoint.getX(), MazeData.exitPoint.getY(), null);
        
        queue.add(startNode);
        visited[startNode.getY()][startNode.getX()] = true;
        
    }
    
    public List<Point> solve() {
        while (! queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (isExit(currentNode)) {
                exitNode = currentNode;
                return createPath();
            }

            for (int i = 0; i < 4; i++) {
                int row = currentNode.getX() + DIRECTIONS[i][0];
                int col = currentNode.getY() + DIRECTIONS[i][1];
                
                Node neighbour = new Node(row, col, currentNode);
                
                if (isCorrectCell(neighbour)) {
                    queue.add(neighbour);
                    visited[col][row] = true;
                }
            }
            
        }
        return null; //no path :(
    }
    private boolean isCorrectCell(Node n) {
        if (!isInBounds(n))
            return false;
        if (isWall(n))
            return false;
        if (isVisited(n))
            return false;
        return true;
    }
    
    private boolean isWall(Node n) {
        if (maze[n.getY()][n.getX()] == MazeData.WALL)
            return true;
        return false;
    }
    
    private boolean isInBounds(Node n) {
        if (n.getY() >= 0 && n.getX() >= 0 && n.getX() < width && n.getY() < height)
            return true;
        return false;
    }
    
    private boolean isVisited(Node n) {
        return (visited[n.getY()][n.getX()]);
    }
    
    private boolean isExit(Node n) {
        if (n.getY() == exitNode.getY() && n.getX() == exitNode.getX())
            return true;
        return false;
    }
    
    private List<Point> createPath() {
        List<Point> path = new LinkedList<>();
        Node currentNode = exitNode;
        System.out.println(exitNode);
        
        while (currentNode != null) {
            path.add(0, new Point(currentNode.getX(), currentNode.getY()));
            currentNode = currentNode.getPrevious();
        }
        
        return path;
    }
    
    public static void main(String []args) {
        boolean[] b = new boolean[2];
        System.out.println(b[0] + " " + b[1]);
    }
}
