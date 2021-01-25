package net.mattemactics.twitchtroll.core.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class ModUtils {
    public static int randBetweenTwoValues(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    static InputStream input;
    public static String getValue(String key) throws IOException {
        String result = "";

        try{
            Properties prop = new Properties();
            String propFileName = "config.properties";

            input = GetProperties.class.getClassLoader().getResourceAsStream(propFileName);

            if(input != null) prop.load(input);
            else throw new FileNotFoundException("property file:"+ propFileName + " was not found");
            result = prop.getProperty(key);
        }catch (Exception e){

        }finally {
            input.close();
        }


        return result;
    }
}
