package net.mattemactics.testmod.core.util;

import java.util.Random;

public class ModUtils {
    public static int randBetweenTwoValues(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
