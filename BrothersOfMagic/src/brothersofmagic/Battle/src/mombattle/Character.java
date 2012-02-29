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
    private int maxhp, maxmp, hp, mp, at, df, sp, x, y;
    private ImageIcon sprite;
 
    public Character( int h, int m, int a, int d, int s, int x, int y, ImageIcon sprite)
    {
        maxhp = h;
        maxmp = m;
        hp = h;
        mp = m;
        at = a;
        df = d;
        sp = s;
        this.x = x;
        this.y = y;
        
        this.sprite = sprite;
        
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
