/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import Graphics.OpenGL.GLUtil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Andrew
 */
public class BattleGraphics extends JPanel{
    Character prime;
    Character[] c1;
    Character[] c2;
    BStat stat1, stat2;
    
            //Largely arbetraty sidelength of each cell
    int size = 30;
        //Also arbetrary number of cells side.
    int side = 10;
    
    
    public BattleGraphics(Character[] player, Character[] computer)
    {
        c1 = player;
        c2 = computer;
        prime = c1[0];
    
    this.setLayout(new BorderLayout());
    
//    stat1 = new BStat(prime);
   // stat2 = new BStat(c2[1]);
  //  this.add(stat2, BorderLayout.NORTH);
    this.add(new BBoard(), BorderLayout.CENTER);
  //  this.add(stat1, BorderLayout.SOUTH);
 
   
    }
    


    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    
    }

    void drawScreen() {
        
        
        Display.update();
    }
    
    
    private class BattleUI implements MouseListener
    {
        
        public void mouseClicked(MouseEvent e) {
               Point p = e.getPoint();
                p.x = p.x / size;
                p.y = p.y / size;
                gameAction(p);
     
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
            g.setColor(Color.lightGray);
            for(int i = 0; i <side; i++)
            {
               g.drawLine(i * size, 0, i * size , size * side);
               g.drawLine(0 , i* size, size*side, i * size);
               
               
            }
            g.setColor(Color.black);
            
            g.drawRect((prime.getX()*size) - 1, (prime.getY()*size) - 1, side + 2, size + 2);
            
            
            for(Character c : c1)
            {
                
                
      //          g.fillOval(c1.getX() * size, c1.getY()* size, size, size);
            c.getSprite().paintIcon(this, g, size * c.getX(), size * c.getY());
            
            if(c.getHp() > 0){
                
            
            g.setColor(Color.black);
            g.drawRect(size * c.getX(), (size * c.getY()) + 25, 29, 5);
            g.setColor(Color.green);
            g.fillRect((size * c.getX()) + 1, (size * c.getY()) + 26, ((c.getHp() * 29) /c.getMaxHp()), 4);
            }
            }
                
            for(Character c : c2)
            {
       
                c.getSprite().paintIcon(this, g, size * c.getX(), size * c.getY());
                if(c.getHp() > 0)
                {
                g.setColor(Color.black);
                g.drawRect(size * c.getX(), (size * c.getY()) + 25, 29, 5);
                g.setColor(Color.green);
                g.fillRect((size * c.getX()) + 1, (size * c.getY()) + 26, ((c.getHp() * 29) /c.getMaxHp()), 4);
                }
        }
        
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
        
    public boolean isOccupied(Point p)
    {
        for(Character c: c1)
        { if((p.x == c.getX()) && (p.y == c.getY()))
            return true;
        }
        for(Character c: c2)
        { if((p.x == c.getX()) && (p.y == c.getY()))
            return true;
        }

        return false;
    }
    
    
    public void gameAction(Point p)
    {
        if(isOccupied(p))
        {
        for(Character c: c2)
        {
        if(prime.getSp() > 0)
        if((p.x == c.getX()) && (p.y == c.getY()) && ((Math.abs(prime.getX() - c.getX()) <= 1) && (Math.abs(prime.getY() - c.getY()) <= 1 )))
        {
            prime.attack(c);
            prime.move();
            break;
        }
        }
        for(Character c: c1)
        {
            if((p.x == c.getX()) && (p.y == c.getY()))
        {
            prime = c;
          //  stat1 = new BStat(prime);
          //  stat1.repaint();
            
        } 
        }
        }
        else if((Math.abs(prime.getX() - p.x) <= 1) && (Math.abs(prime.getY() - p.y) <= 1 ))
           {
               if(prime.getSp() > 0)
               {
               prime.setX(p.x);
               prime.setY(p.y);
               prime.move();
               }
           }
        
        
        
       // System.out.println("tim HP : " + c2[0].getHp() + " tim2 HP : " + c2[1].getHp() + " tim3 HP : " + c2[2].getHp());
        repaint();

    }

   
    
    
    
}
