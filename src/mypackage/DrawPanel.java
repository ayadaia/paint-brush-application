/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;


public class DrawPanel extends JPanel {
    
    
    
    JButton lineBtn;
    JButton rectBtn;
    JButton ovalBtn;
    JButton freehandBtn;
    JButton eraserBtn;
    JButton clearBtn;
    JCheckBox dottedCk,solidCk;
    
    Shape currentshape=null;
    
    //arraylist to save every small line drawed by the mouse in free hand 
   ArrayList <int[]> freehandlines = new ArrayList<>();
    //arraylist to save all the shapes drawn on the screen 
    ArrayList<Shape> shapes = new ArrayList<>();
    //arraylist for eraser 
    ArrayList<int[]> eraserLines = new ArrayList<>();
    
    int x1, y1, x2, y2;
    boolean dragging = false;
    boolean isDotted = false;
       boolean isSolid = true;
       
    DrawPanel(){
        this.setBackground(Color.WHITE);
        //draw buttons using lambda
        lineBtn=new JButton("line");
        lineBtn.addActionListener(e->currentshape=new Line(0,0,0,0,isDotted));
        this.add(lineBtn);
        
        rectBtn=new JButton("Rectangle");
        rectBtn.addActionListener(e->currentshape=new Rectangle(0,0,0,0,isDotted));
        this.add(rectBtn);
        
        ovalBtn=new JButton("Oval");
        ovalBtn.addActionListener(e->currentshape=new Oval(0,0,0,0,isDotted));
        this.add(ovalBtn);
        
        freehandBtn=new JButton("Pencil");
        freehandBtn.addActionListener(e->currentshape=new FreeHand(0,0,0,0,isDotted));
        this.add(freehandBtn);
        
        eraserBtn = new JButton("Eraser");
        eraserBtn.addActionListener(e -> currentshape = new Eraser(0,0,0,0,isDotted));
        this.add(eraserBtn);
        
        clearBtn = new JButton("Clear All");
        clearBtn.addActionListener(e -> {
                      shapes.clear();
                     freehandlines.clear();
                    eraserLines.clear(); 
                     repaint();
                      });
       this.add(clearBtn);
        
       dottedCk = new JCheckBox("Dotted");
       solidCk = new JCheckBox("Solid");
        this.add(dottedCk);
        this.add(solidCk);
        
        dottedCk.addActionListener(e -> {
            if (dottedCk.isSelected()) {
                isDotted = true;
                isSolid = false;
                solidCk.setEnabled(false);
            } else {
                isDotted = false;
                solidCk.setEnabled(true);
            }
            repaint();
        });
       
       solidCk.addActionListener(e -> {
            if (solidCk.isSelected()) {
                isSolid = true;
                isDotted = false;
                dottedCk.setEnabled(false);
            } else {
                isSolid = false;
                dottedCk.setEnabled(true);
            }
            repaint();
        });
       
       
        //action listener for drawing shapes 
         MyMouseListener m = new MyMouseListener();
         this.addMouseListener(m);
         MyMouseMotionListener ms = new MyMouseMotionListener(); 
         this.addMouseMotionListener(ms);
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
         
        //for loop to print all the shapes from arraylist shapes
        for (Shape s : shapes) {
            if (s.isDotted) {
        float[] dash = {5f, 5f};
        g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT,
                                     BasicStroke.JOIN_MITER, 10f, dash, 0f));
    } else {
        g2.setStroke(new BasicStroke(2));
    }
            g.setColor(Color.BLACK);
          s.draw(g);
        }
        
         //for loop to print the free hand from arraylist freehandline
        //g.setColor(Color.BLACK);
        for (int[] l : freehandlines) {
            
            g.drawLine(l[0], l[1], l[2], l[3]);
        }
        
        g.setColor(Color.WHITE);
        for (int[] e : eraserLines) {
            
            g.fillOval(e[0], e[1], 15 ,15);
        }
        
        
        //to draw the current shape on the screen 
      if (dragging && currentshape != null) {
        if (currentshape instanceof FreeHand) {
            g.setColor(Color.BLACK);
        } else if (currentshape instanceof Eraser) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
           currentshape.draw(g);
        
       }          
    }  
    
    
    public class MyMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            x1=e.getX();
            y1=e.getY();
            
            x2=x1;
            y2=y1;
            
            dragging=true;
           
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          dragging = false;
          
          if (currentshape instanceof Line) {
        shapes.add(new Line(x1, y1, x2, y2,isDotted));
    } else if (currentshape instanceof Rectangle) {
        shapes.add(new Rectangle(x1, y1, x2, y2,isDotted));
    } else if (currentshape instanceof Oval) {
        shapes.add(new Oval(x1, y1, x2, y2,isDotted));
    }
            
        currentshape = null;
          repaint();
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }
      public class MyMouseMotionListener implements MouseMotionListener
     {

        @Override
        public void mouseDragged(MouseEvent e) {
             x2=e.getX();
             y2=e.getY();
             
             if (currentshape != null) {
                   currentshape.x1 = x1;
                   currentshape.y1 = y1;
                   currentshape.x2 = x2;
                   currentshape.y2 = y2;
    }
            if(currentshape instanceof FreeHand )
            {
               freehandlines.add(new int[]{x1,y1,x2,y2}); 
               x1=x2;
               y1=y2;
            } else if (currentshape instanceof Eraser) {
                  
             eraserLines.add(new int[]{x2, y2});
              x1 = x2;
              y1 = y2;
             
            }
            
          repaint(); 
           
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            
        }
         
     }
    
    
    } 

