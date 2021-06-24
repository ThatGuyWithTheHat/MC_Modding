package net.mattemactics.twitchtroll.core.util;

import net.mattemactics.twitchtroll.client.util.ModSettings;

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
        commandCost.put("!creeper", ModSettings.getCreeperCost());
        commandCost.put("!zombie", ModSettings.getZombieCost());
        commandCost.put("!skelly", ModSettings.getSkellyCost());
        //commandCost.put("!tnt", 600);
        commandCost.put("!anvil", ModSettings.getAnvilCost());
        commandCost.put("!ghast", ModSettings.getGhastCost());
        commandCost.put("!fire", ModSettings.getFireCost());
        commandCost.put("!goodboy", ModSettings.getGoodboyCost());
        commandCost.put("!dropitall", ModSettings.getDropitallCost());
        commandCost.put("!dropit", ModSettings.getDropitCost());
        commandCost.put("!boom", ModSettings.getBoomCost());
        commandCost.put("!enderman", ModSettings.getEndermanCost());
        commandCost.put("!blaze", ModSettings.getBlazeCost());
        commandCost.put("!bees", ModSettings.getBeesCost());
        commandCost.put("!cow", ModSettings.getCowCost());
        commandCost.put("!chicken", ModSettings.getChickenCost());
        commandCost.put("!piggy", ModSettings.getPiggyCost());
        commandCost.put("!parrot", ModSettings.getParrotCost());
        commandCost.put("!baa", ModSettings.getBaaCost());
    }

    public static void updateCommandCost(){
        commandCost.put("!creeper", ModSettings.getCreeperCost());
        commandCost.put("!zombie", ModSettings.getZombieCost());
        commandCost.put("!skelly", ModSettings.getSkellyCost());
        //commandCost.put("!tnt", 600);
        commandCost.put("!anvil", ModSettings.getAnvilCost());
        commandCost.put("!ghast", ModSettings.getGhastCost());
        commandCost.put("!fire", ModSettings.getFireCost());
        commandCost.put("!goodboy", ModSettings.getGoodboyCost());
        commandCost.put("!dropitall", ModSettings.getDropitallCost());
        commandCost.put("!dropit", ModSettings.getDropitCost());
        commandCost.put("!boom", ModSettings.getBoomCost());
        commandCost.put("!enderman", ModSettings.getEndermanCost());
        commandCost.put("!blaze", ModSettings.getBlazeCost());
        commandCost.put("!bees", ModSettings.getBeesCost());
        commandCost.put("!cow", ModSettings.getCowCost());
        commandCost.put("!chicken", ModSettings.getChickenCost());
        commandCost.put("!piggy", ModSettings.getPiggyCost());
        commandCost.put("!parrot", ModSettings.getParrotCost());
        commandCost.put("!baa", ModSettings.getBaaCost());
    }

    public TwitchViewer(String userName){
        this.USER_NAME = userName;
        this.TROLL_COIN_COUNT = 50;
        this.startTime = System.currentTimeMillis();

    }

    public static Map<String, Integer> getCommandCost(){
        return commandCost;
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
