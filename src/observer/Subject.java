/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package observer;

public interface Subject {
    
    public void addObserver();
    
    public void removeObserver();
    
    public void notifyObservers();
}
