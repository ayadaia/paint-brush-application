/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypackage;

import java.awt.Graphics;


public class Oval extends Shape {

    public Oval(int x1, int y1, int x2, int y2,boolean isDotted) {
        super(x1, y1, x2, y2, isDotted);
       


       
    }
    
    @Override
    void draw(Graphics g ) {
        // make the start of the draw always from the small dimension  
        int startx=Math.min(x1, x2);
        int starty=Math.min(y1, y2);
        //make the width and height always positive number 
        int w=Math.abs(x1-x2);
        int h=Math.abs(y1-y2);
        
         g.drawOval(startx,starty,w,h);  
    }
   
}
