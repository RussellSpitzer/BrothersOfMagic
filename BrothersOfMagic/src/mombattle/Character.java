/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import javax.swing.ImageIcon;

/**
 *
 * @author Andrew
 */
public class Character {
    private int maxhp, maxmp, maxsp, hp, mp, at, df, sp, x, y;
    private ImageIcon sprite;
 
    public Character( int h, int m, int a, int d, int s, int x, int y, ImageIcon sprite)
    {
        maxhp = h;
        maxmp = m;
        maxsp = sp;
        hp = h;
        mp = m;
        at = a;
        df = d;
        sp = s;
        this.x = x;
        this.y = y;
        
        this.sprite = sprite;
        
    }

    public Character(int i, int i0, int i1, int i2, int i3, int i4, int i5, String path) { 
        this (i,i0,i1,i2,i3,i4,i5,new ImageIcon());
        System.out.println(path);
        java.net.URL imgUrl = getClass().getResource(path);
        if (imgUrl==null) {
            System.out.println("Resource Not Found");
            return;
        }
        this.sprite=new ImageIcon(imgUrl);
    }
    
    public ImageIcon getSprite()
    {
        return sprite;
    }
    public int getX()
    {
        return x;
    }
    public void setX(int newX)
    {
        x = newX;
    }
    public void setY(int newY)
    {
        y = newY;
    }
    public void move()
    {
        sp--;
    }
    public void rest()
    {
        sp = maxsp;
    }            
    public int getY()
    {
        return y;
    }
    public int getHp()
    {
        return hp;
    }
    
    public int getMaxHp()
    {
        return maxhp;
    }
    
    public int getMp()
    {
        return mp;
    }
    public int getMaxMp()
    {
        return maxmp;
    }
    public int getAt()
    {
        return at;
    }
    public int getSp()
    {
        return sp;
    }
    
    public void attack(Character ch)
    {
     ch.attacked(at);   
    
    }
    
    public void attacked(int enAt)
    {
        if (enAt>df)
            hp = hp - (enAt - df); 
    }
    
    
}
