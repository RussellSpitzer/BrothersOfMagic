/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import java.util.ArrayList;
import mombattle.units.BaseUnit;

/**
 *
 * @author MagRus
 */
public class BattleManager {
    public ArrayList<BaseUnit> currUnits=new ArrayList<BaseUnit>(); //All the units in the battle
    private ArrayList<BaseUnit> buffUnits=new ArrayList<BaseUnit>(); //A bufffer to put pose processing units in
    public void init(){
        
        //TODO SET up a GAMEWORLD and FIGURE OUT A WAY TO ADD IN UNITS FROM GAMEWORLD Stacks of units?
        currUnits.add(new mombattle.units.Character(20, 20, 10, 10, 5, 60, 120, "RedKnightSmall"));
        currUnits.add(new mombattle.units.Character(20, 20, 10, 10, 5, 460, 320, "BlueKnightSmall"));
        currUnits.add(new mombattle.units.Character(20, 20, 10, 10, 5, 140, 170, "BlueKnightSmall"));
        
    }
    
}
