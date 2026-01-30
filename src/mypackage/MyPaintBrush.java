/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypackage;

import javax.swing.JFrame;


public class MyPaintBrush {
    public static void main(String[] args) {
        JFrame jf =new JFrame();
        
        jf.setTitle("Paint Brush");
        jf.setSize(800,800);
        jf.setVisible(true);
       
        DrawPanel dp = new DrawPanel();
        jf.setContentPane(dp);
                
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
