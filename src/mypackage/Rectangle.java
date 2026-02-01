/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypackage;

import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Shape {

	
	 int startx, starty, w, h;
	
    public Rectangle(int x1, int y1, int x2, int y2,boolean isDotted, boolean isFilled, Color color) {
        super( x1, y1, x2, y2, isDotted, isFilled, color);
        


        
    }
    
    @Override
    void draw(Graphics g) {
        // make the start of the draw always from the small dimension  
         startx=Math.min(x1, x2);
         starty=Math.min(y1, y2);
        //make the width and height always positive number 
         w=Math.abs(x1-x2);
         h=Math.abs(y1-y2);
        
        
        
        if(isFilled) {
        	g.fillRect(startx, starty, w, h);
        }else {g.drawRect(startx, starty, w, h);}
        
        //g.fill3DRect(startx, starty, w, h, isFilled());
        
    }
    
}
