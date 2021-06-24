package net.mattemactics.twitchtroll.client.util;

import net.mattemactics.twitchtroll.core.util.TwitchViewer;

import java.util.Map;

public class ModSettings {
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

    public static final String AUTH = "oauth:po7g55tbm2det2nii1f29u3uzcxgmt";
    public static int getSkellyCost() {
        return skellyCost;
    }

    public static void setSkellyCost(int skellyCost) {
        ModSettings.skellyCost = skellyCost;
        TwitchViewer.updateCommandCost();
    }

    public static Boolean getTest() {
        return test;
    }

    public static void setTest(Boolean test) {
        ModSettings.test = test;
        TwitchViewer.updateCommandCost();
    }

    public static int getCreeperCost() {
        return creeperCost;
    }

    public static void setCreeperCost(int creeperCost) {
        ModSettings.creeperCost = creeperCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getZombieCost() {
        return zombieCost;
    }

    public static void setZombieCost(int zombieCost) {
        ModSettings.zombieCost = zombieCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getAnvilCost() {
        return anvilCost;
    }

    public static void setAnvilCost(int anvilCost) {
        ModSettings.anvilCost = anvilCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getGhastCost() {
        return ghastCost;
    }

    public static void setGhastCost(int ghastCost) {
        ModSettings.ghastCost = ghastCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getFireCost() {
        return fireCost;
    }

    public static void setFireCost(int fireCost) {
        ModSettings.fireCost = fireCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getGoodboyCost() {
        return goodboyCost;
    }

    public static void setGoodboyCost(int goodboyCost) {
        ModSettings.goodboyCost = goodboyCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getDropitallCost() {
        return dropitallCost;
    }

    public static void setDropitallCost(int dropitallCost) {
        ModSettings.dropitallCost = dropitallCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getDropitCost() {
        return dropitCost;
    }

    public static void setDropitCost(int dropitCost) {
        ModSettings.dropitCost = dropitCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getBoomCost() {
        return boomCost;
    }

    public static void setBoomCost(int boomCost) {
        ModSettings.boomCost = boomCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getEndermanCost() {
        return endermanCost;
    }

    public static void setEndermanCost(int endermanCost) {
        ModSettings.endermanCost = endermanCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getBlazeCost() {
        return blazeCost;
    }

    public static void setBlazeCost(int blazeCost) {
        ModSettings.blazeCost = blazeCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getBeesCost() {
        return beesCost;
    }

    public static void setBeesCost(int beesCost) {
        ModSettings.beesCost = beesCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getCowCost() {
        return cowCost;
    }

    public static void setCowCost(int cowCost) {
        ModSettings.cowCost = cowCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getChickenCost() {
        return chickenCost;
    }

    public static void setChickenCost(int chickenCost) {
        ModSettings.chickenCost = chickenCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getPiggyCost() {
        return piggyCost;
    }

    public static void setPiggyCost(int piggyCost) {
        ModSettings.piggyCost = piggyCost;
        TwitchViewer.updateCommandCost();

    }

    public static int getParrotCost() {
        return parrotCost;
    }

    public static void setParrotCost(int parrotCost) {
        ModSettings.parrotCost = parrotCost;
        TwitchViewer.updateCommandCost();
    }

    public static int getBaaCost() {
        return baaCost;
    }

    public static void setBaaCost(int baaCost) {
        ModSettings.baaCost = baaCost;
        TwitchViewer.updateCommandCost();
    }

    public static void SAVE(){
        StringBuilder saveData = new StringBuilder();
        String costHeader = "-------COSTS--------";
        String costEnder = "-------ENDCOSTS--------";

        saveData.append(costHeader);
        TwitchViewer.updateCommandCost();
        Map<String, Integer> costMap = TwitchViewer.getCommandCost();
        saveData.append(costHeader);
        saveData.append("\n");
        for(String key: costMap.keySet()){
            saveData.append(key);
            saveData.append(',');
            saveData.append(costMap.get(key));
            saveData.append('\n');
        }
        saveData.append(costEnder);


    }
}
