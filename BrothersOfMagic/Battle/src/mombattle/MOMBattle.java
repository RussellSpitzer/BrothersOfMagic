/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Andrew
 */
public class MOMBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Character bob1 = new Character( 10, 5, 4, 1, 100, 5, 9, new ImageIcon("BlueKnightSmall.jpg"));
        Character bob2 = new Character( 10, 5, 2, 1, 100, 4, 9, new ImageIcon("BlueSoldierSmall.jpg"));
        Character tim1 = new Character( 10, 5, 2, 1, 1, 4, 0, new ImageIcon("RedKnightSmall.jpg"));
        Character tim2 = new Character( 10, 5, 2, 1, 1, 5, 0, new ImageIcon("RedKnightSmall.jpg"));
        Character tim3 = new Character( 10, 5, 2, 1, 1, 6, 0, new ImageIcon("RedKnightSmall.jpg"));
        Character[] player = {bob1, bob2};
        Character[] computer = {tim1, tim2, tim3};
        BattleGraphics battle = new BattleGraphics(player, computer);

     //   System.out.println("Bob hp: " + bob.getHp());
     //   System.out.println("Tim hp: " + tim.getHp());
     //   System.out.println("Bob attacks Tim");
     //   bob.attack(tim);
     //   System.out.println("Tim hp: " + tim.getHp());
       // System.out.println("Tim attacks Bob");
       // tim.attack(bob);
       // System.out.println("Bob hp: " + bob.getHp());
       
        JFrame frame = new JFrame("BATTLE!");
        frame.add(battle);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
    }
}
