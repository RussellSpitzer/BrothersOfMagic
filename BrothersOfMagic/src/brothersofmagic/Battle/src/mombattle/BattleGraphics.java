/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Andrew
 */
public class BattleGraphics extends JPanel{
    Character c1, c2;
    BStat stat1, stat2;
    
            //Largely arbetraty sidelength of each cell
    int size = 30;
        //Also arbetrary number of cells side.
    int side = 10;
    
    
    public BattleGraphics(Character b, Character t)
    {
    c1 = b;
    c2 = t;
    
    stat1 = new BStat(c1);
    stat2 = new BStat(c2);
    

    
    this.setLayout(new BorderLayout());
    this.add(stat2, BorderLayout.NORTH);
    this.add(new BBoard(), BorderLayout.CENTER);
    this.add(stat1, BorderLayout.SOUTH);
 
   
    }
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    
    }
    
    
    private class BattleUI implements MouseListener
    {
        
        public void mouseClicked(MouseEvent e) {
               Point p = e.getPoint();
                p.x =p.x/size;
                p.y = p.y/size;
                gameAction(p);
                stat1.repaint();
                        
                }

         public void mousePressed(MouseEvent e) {
            
        }

       
        public void mouseReleased(MouseEvent e) {
           
        }

       
        public void mouseEntered(MouseEvent e) {
          //  if((e.getX() < 30 * c1.getX() && e.getX() < 30 * c1.getX() + 30) && (e.getY() < 30 * c1.getY() && e.getY() < (30 * c1.getY()) + 30))
        //     
                
        //    if((e.getX() < 30 * c1.getX() && e.getX() < 30 * c1.getX() + 30) && (e.getY() < 30 * c1.getY() && e.getY() < (30 * c1.getY()) + 30))
                            
                
        }
        
         
        public void mouseExited(MouseEvent e) {
          
        }
    }
    
    
    private class BBoard extends JPanel
    {

        
        public BBoard()
        {
                BattleUI battleui = new BattleUI();
                addMouseListener(battleui);
           // this.setSize(300, 300);
            this.setPreferredSize(new Dimension(size*side, size*side));
            this.setBackground(Color.white);
           
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.black);
            for(int i = 0; i <side; i++)
            {
               g.drawLine(i * size, 0, i * size , size * side);
               g.drawLine(0 , i* size, size*side, i * size);
               
               
            }
            c1.getSprite().paintIcon(this, g, size * c1.getX(), size * c1.getY());
            c2.getSprite().paintIcon(this, g, size * c2.getX(), size * c2.getY());
        }
        
    }
    
    
    private class BStat extends JPanel
    {

        Character ch;
        Color c;
        JLabel label1;
        JLabel label2;
        
        BStat(Character character)
        {
            ch = character;
            
            setBackground(Color.white);
            this.setPreferredSize(new Dimension(100, 100));
//            this.setSize(200,100);

            
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.drawRect(5, 20, 41, 6);
            g.drawRect(5, 30, 41, 6);
            g.setColor(Color.green);
            g.fillRect(6, 21, ((ch.getHp() * 39) /ch.getMaxHp()), 4);
            g.setColor(Color.PINK);
            g.fillRect(6, 31, ((ch.getMp() * 39) /ch.getMaxMp()), 4);
            ch.getSprite().paintIcon(this, g, 100, 20);
            g.setColor(Color.black);
            g.drawString("HP: " + ch.getHp(), 50, 20);
            g.drawString("MP: " + ch.getMp(), 50, 30);

        }

        
        
    }
    
    
    public void gameAction(Point p)
    {
        if((p.x >= c2.getX()) && (p.x <= c2.getX() + 1) && (p.y >= c2.getY()) && (p.y <= c2.getY() + 1))
            c1.attack(c2);
        else
        {
            c1.setX(p.x);
            c1.setY(p.y);
        }
        
       // System.out.println("Tim HP: " + c2.getHp());
        repaint();

    }
    
   
    
    
    
}
