package net.mattemactics.twitchtroll.core.util;

import java.util.HashMap;
import java.util.Map;

public class TwitchViewer {
    public String USER_NAME = "";
    public Integer TROLL_COIN_COUNT = 0;
    long startTime = 0;
    public static boolean DEBUG = false;

    public static long deltaTimeForIncrease = 20000;
    public static Integer increase = 15;
    public static Map<String, Integer> commandCost = new HashMap<>();

    static{
            commandCost.put("!creeper", 300);
            commandCost.put("!zombie", 50);
            commandCost.put("!skelly", 65);
            //commandCost.put("!tnt", 600);
            commandCost.put("!anvil", 30);
            commandCost.put("!ghast", 300);
            commandCost.put("!fire", 200);
            commandCost.put("!goodboy", 100);
            commandCost.put("!dropitall", 1500);
            commandCost.put("!dropit", 500);
            commandCost.put("!boom", 500);
            commandCost.put("!enderman", 300);
            commandCost.put("!blaze", 300);
            commandCost.put("!bees", 100);
            commandCost.put("!cow", 20);
            commandCost.put("!chicken", 20);
            commandCost.put("!piggy", 20);
            commandCost.put("!parrot", 20);
            commandCost.put("!baa", 20);
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

    public void givePoints(Integer x){

        this.TROLL_COIN_COUNT = this.TROLL_COIN_COUNT + x;
    }

    public void refundPoints(String command){
        if(commandCost.containsKey(command)){
            Integer cost = commandCost.get(command);
            this.TROLL_COIN_COUNT = this.TROLL_COIN_COUNT + cost;

        }
    }



    public boolean costPoints(String command){
        if(commandCost.containsKey(command)){
            Integer cost = commandCost.get(command);
            if(cost > TROLL_COIN_COUNT && !DEBUG){
                return false;
            }else{
                if(!DEBUG) this.TROLL_COIN_COUNT = this.TROLL_COIN_COUNT - cost;
            }
        }
        return true;
    }
}
