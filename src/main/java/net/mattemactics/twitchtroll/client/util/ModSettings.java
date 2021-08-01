package net.mattemactics.twitchtroll.client.util;

import net.mattemactics.twitchtroll.core.util.TwitchViewer;

import java.util.ArrayList;
import java.util.Map;

public class ModSettings {
    private static String FILENAME = "modSettings.csv";
    static Boolean test = false;

    //costsForCommand
    static int creeperCost = 300;
    static int zombieCost = 50;
    static int anvilCost = 30;
    static int ghastCost = 300;
    static int fireCost = 200;
    static int goodboyCost = 100;
    static int dropitallCost=1500;
    static int dropitCost = 500;
    static int boomCost = 600;
    static int endermanCost = 100;
    static int blazeCost = 300;
    static int beesCost = 100;
    static int cowCost = 20;
    static int chickenCost = 20;
    static int piggyCost = 20;
    static int parrotCost = 20;
    static int baaCost = 20;
    static int skellyCost = 50;

    public static String AUTH = "oauth:po7g55tbm2det2nii1f29u3uzcxgmt";

    public static String getAUTH() {
        return AUTH;
    }

    public static void setAUTH(String auth) {
        ModSettings.AUTH = auth;
    }

    public static int getSkellyCost() {

        return skellyCost;
    }

    public static void setSkellyCost(int skellyCost) {
        ModSettings.skellyCost = skellyCost;

    }

    public static Boolean getTest() {
        return test;
    }

    public static void setTest(Boolean test) {
        ModSettings.test = test;
    }

    public static int getCreeperCost() {
        return ModSettings.creeperCost;
    }

    public static void setCreeperCost(int creeperCost) {
        ModSettings.creeperCost = creeperCost;
        System.out.println("creeper set too: " + ModSettings.creeperCost);
    }

    public static int getZombieCost() {
        return ModSettings.zombieCost;
    }

    public static void setZombieCost(int zombieCost) {
        ModSettings.zombieCost = zombieCost;
    }

    public static int getAnvilCost() {
        return ModSettings.anvilCost;
    }

    public static void setAnvilCost(int anvilCost) {
        ModSettings.anvilCost = anvilCost;
    }

    public static int getGhastCost() {
        return ModSettings.ghastCost;
    }

    public static void setGhastCost(int ghastCost) {
        ModSettings.ghastCost = ghastCost;
    }

    public static int getFireCost() {
        return ModSettings.fireCost;
    }

    public static void setFireCost(int fireCost) {
        ModSettings.fireCost = fireCost;
    }

    public static int getGoodboyCost() {
        return ModSettings.goodboyCost;
    }

    public static void setGoodboyCost(int goodboyCost) {
        ModSettings.goodboyCost = goodboyCost;
    }

    public static int getDropitallCost() {
        return ModSettings.dropitallCost;
    }

    public static void setDropitallCost(int dropitallCost) {
        ModSettings.dropitallCost = dropitallCost;
    }

    public static int getDropitCost() {
        return ModSettings.dropitCost;
    }

    public static void setDropitCost(int dropitCost) {
        ModSettings.dropitCost = dropitCost;
    }

    public static int getBoomCost() {
        return ModSettings.boomCost;
    }

    public static void setBoomCost(int boomCost) {
        ModSettings.boomCost = boomCost;
    }

    public static int getEndermanCost() {
        return ModSettings.endermanCost;
    }

    public static void setEndermanCost(int endermanCost) {
        ModSettings.endermanCost = endermanCost;
    }

    public static int getBlazeCost() {
        return ModSettings.blazeCost;
    }

    public static void setBlazeCost(int blazeCost) {
        ModSettings.blazeCost = blazeCost;
    }

    public static int getBeesCost() {
        return ModSettings.beesCost;
    }

    public static void setBeesCost(int beesCost) {
        ModSettings.beesCost = beesCost;
    }

    public static int getCowCost() {
        return ModSettings.cowCost;
    }

    public static void setCowCost(int cowCost) {
        ModSettings.cowCost = cowCost;
    }

    public static int getChickenCost() {
        return ModSettings.chickenCost;
    }

    public static void setChickenCost(int chickenCost) {
        ModSettings.chickenCost = chickenCost;
    }

    public static int getPiggyCost() {
        return ModSettings.piggyCost;
    }

    public static void setPiggyCost(int piggyCost) {
        ModSettings.piggyCost = piggyCost;

    }

    public static int getParrotCost() {
        return ModSettings.parrotCost;
    }

    public static void setParrotCost(int parrotCost) {
        ModSettings.parrotCost = parrotCost;
    }

    public static int getBaaCost() {
        return ModSettings.baaCost;
    }

    public static void setBaaCost(int baaCost) {
        ModSettings.baaCost = baaCost;
    }

    public static void SAVE(){
        ArrayList<String> saveData = new ArrayList<String>();


        Map<String, Integer> costMap = TwitchViewer.getCommandCost();
        //saveData.add("auth," + ModSettings.getAUTH() + "\n");
        for(String key: costMap.keySet()){
            StringBuilder build = new StringBuilder();
            build.append(key);
            build.append(',');
            build.append(costMap.get(key));
            saveData.add(build.toString());
        }
        FileManager file = new FileManager(FILENAME);
        file.writeFile(saveData);

    }

    public static void LOAD(){
        FileManager file = new FileManager(FILENAME);
        ArrayList<String> fileData = file.readFile();
        if(fileData.isEmpty()) return;
        for(String s: fileData){
            String key = s.split(",")[0];
            String value = s.split(",").length > 1 ? s.split(",")[1] : " ";
            if(key.equals("!blaze")) setBlazeCost(Integer.parseInt(value));
            else if(key.equals("!chicken")) setChickenCost(Integer.parseInt(value));
            else if(key.equals("!zombie")) setZombieCost(Integer.parseInt(value));
            else if(key.equals("!ghast")) setGhastCost(Integer.parseInt(value));
            else if(key.equals("!enderman")) setEndermanCost(Integer.parseInt(value));
            else if(key.equals("!bees")) setBeesCost(Integer.parseInt(value));
            else if(key.equals("!dropitall")) setDropitallCost(Integer.parseInt(value));
            else if(key.equals("!parrot")) setParrotCost(Integer.parseInt(value));
            else if(key.equals("!anvil")) setAnvilCost(Integer.parseInt(value));
            else if(key.equals("!baa")) setBaaCost(Integer.parseInt(value));
            else if(key.equals("!skelly")) setSkellyCost(Integer.parseInt(value));
            else if(key.equals("!goodboy")) setGoodboyCost(Integer.parseInt(value));
            else if(key.equals("!boom")) setBoomCost(Integer.parseInt(value));
            else if(key.equals("!piggy")) setPiggyCost(Integer.parseInt(value));
            else if(key.equals("!fire")) setFireCost(Integer.parseInt(value));
            else if(key.equals("!dropit")) setDropitCost(Integer.parseInt(value));
            else if(key.equals("!creeper")) setCreeperCost(Integer.parseInt(value));
            else if(key.equals("!cow")) setCowCost(Integer.parseInt(value));
            //else if(key.equals("auth") && !value.equals(" ")) setAUTH(value);
        }

        TwitchViewer.updateCommandCost();

    }

    public static void setDefault(){
        ModSettings.creeperCost = 300;
        ModSettings.zombieCost = 50;
        ModSettings.anvilCost = 30;
        ModSettings.ghastCost = 300;
        ModSettings.fireCost = 200;
        ModSettings.goodboyCost = 100;
        ModSettings.dropitallCost=1500;
        ModSettings.dropitCost = 500;
        ModSettings.boomCost = 600;
        ModSettings.endermanCost = 100;
        ModSettings.blazeCost = 300;
        ModSettings.beesCost = 100;
        ModSettings.cowCost = 20;
        ModSettings.chickenCost = 20;
        ModSettings.piggyCost = 20;
        ModSettings.parrotCost = 20;
        ModSettings.baaCost = 20;
        ModSettings.skellyCost = 50;
    }
}
