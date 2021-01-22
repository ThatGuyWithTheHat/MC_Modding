package net.mattemactics.testmod.core.util;

import java.util.HashMap;
import java.util.Map;

public class TwitchViewer {
    public String USER_NAME = "";
    public Integer TROLL_COIN_COUNT = 0;
    long startTime = 0;
    public static boolean DEBUG = true;

    public static long deltaTimeForIncrease = 20000;
    public static Integer increase = 15;
    public static Map<String, Integer> commandCost = new HashMap<>();

    static{
        if(DEBUG){
            commandCost.put("!creeper", 0);
            commandCost.put("!zombie", 0);
            commandCost.put("!skelly", 0);
            commandCost.put("!tnt", 0);
            commandCost.put("!anvil", 0);
            commandCost.put("!ghast", 0);
            commandCost.put("!fire", 0);
        }else {
            commandCost.put("!creeper", 50);
            commandCost.put("!zombie", 15);
            commandCost.put("!skelly", 40);
            commandCost.put("!tnt", 50);
            commandCost.put("!anvil", 15);
            commandCost.put("!ghast", 150);
            commandCost.put("!fire", 100);
        }
    }

    public TwitchViewer(String userName){
        this.USER_NAME = userName;
        this.TROLL_COIN_COUNT = 50;
        this.startTime = System.currentTimeMillis();

    }

    public static boolean onCommandList(String command){
        return commandCost.containsKey(command);
    }

    public Integer getPoints(){return this.TROLL_COIN_COUNT;}

    public void pointsIncrease(){

        if(System.currentTimeMillis() - this.startTime > deltaTimeForIncrease) {
            this.TROLL_COIN_COUNT = this.TROLL_COIN_COUNT + increase;
            this.startTime = System.currentTimeMillis();
        }
    }

    public boolean costPoints(String command){
        if(commandCost.containsKey(command)){
            Integer cost = commandCost.get(command);
            if(cost > TROLL_COIN_COUNT){
                return false;
            }else{
                this.TROLL_COIN_COUNT = this.TROLL_COIN_COUNT - cost;
            }
        }
        return true;
    }
}
