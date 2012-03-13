/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import Graphics.OpenGL.GLTextureLoader;
import java.util.ArrayList;
import mombattle.units.*;
//import mombattle.units.BaseUnit;

/**
 *
 * @author MagRus
 */
public class BattleManager {
    public ArrayList<BaseUnit> currUnits=new ArrayList<BaseUnit>(); //All the units in the battle
    public ArrayList<ArmyUnit> army1 = new ArrayList<ArmyUnit>();
    public ArrayList<ArmyUnit> army2 = new ArrayList<ArmyUnit>();
    public ArrayList<ArmyUnit> armies = new ArrayList<ArmyUnit>();
    private ArrayList<BaseUnit> buffUnits=new ArrayList<BaseUnit>(); //A bufffer to put pose processing units in
    ArmyUnit blueGuy;
    ArmyUnit redGuy;
    ArmyUnit blueSold;
    BaseUnit rock1;
    ArmyUnit prime;

    
    public void init(){
        
        //Here are just some BaseUnits that can be added to currUnits specifically by name.
        rock1 = new BaseUnit() {}; rock1.battleMapX = 60; rock1.battleMapY = 60; rock1.sprite = GLTextureLoader.textureMap.get("Rock");        
        blueGuy = new ArmyUnit(20, 20, 11, 10, 5, 0, 0, "BlueKnightSmall");
        redGuy = new ArmyUnit(20, 20, 10, 10, 5, 60, 120, "RedKnightSmall");
        blueSold = new ArmyUnit(10, 10, 10, 10, 5, 90, 210, "BlueSoldierSmall");

        //TODO SET up a GAMEWORLD and FIGURE OUT A WAY TO ADD IN UNITS FROM GAMEWORLD Stacks of units?

        army1.add(redGuy);
        army2.add(blueGuy);
        army2.add(blueSold);
        army2.add(new mombattle.units.ArmyUnit(20, 20, 11, 10, 5, 450, 330, "BlueKnightSmall"));
        armies.addAll(army1);
        armies.addAll(army2);

        currUnits.add(rock1);                
        currUnits.addAll(armies);
                                
    }
    
    public void play(int x, int y) {
        boolean occupied = false;
        for(ArmyUnit a : armies)
        {
            if(x == a.battleMapX && y == a.battleMapY)
            {
                occupied = true;
                if(army1.contains(a))
                {
                    prime.attack(a);
                    if(a.getHp() <= 0)
                    {
                        // Stop checking for unit
                        armies.remove(a);
                        army1.remove(a);
                        // Stop drawing unit
                        currUnits.remove(a);
                    }
                    break;
                }
                else
                {
                    prime = a;
                    break;
                }

            }
            
        }
        if (! occupied)
        {
            prime.setX(x);
            prime.setY(y);
        }
        
        
                    
        
    }
}


