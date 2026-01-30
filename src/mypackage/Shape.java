/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypackage;

import java.awt.Graphics;


abstract class Shape {
    
   //enum shapetype{Line,Rectangle,Oval};
    //shapetype shapetype;
    
    int x1,y1,x2,y2;
    boolean isDotted;
    public Shape(int x1, int y1, int x2, int y2,boolean isDotted) {
      
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.isDotted = isDotted;
    }

    
    
    
    
    abstract void draw(Graphics g);
    
}
