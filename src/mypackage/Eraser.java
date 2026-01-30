/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypackage;

import java.awt.Color;
import java.awt.Graphics;


public class Eraser extends Shape{

    public Eraser(int x1, int y1, int x2, int y2,boolean isDotted) {
        super(x1, y1, x2, y2, isDotted);
    }
    
     @Override
    void draw(Graphics g) {
         g.setColor(Color.WHITE);  
         g.fillOval(x1,y1,15,15);
           
    }
    
}
