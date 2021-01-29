package net.mattemactics.twitchtroll.core.util;

import com.cavariux.twitchirc.Chat.Channel;
import net.mattemactics.twitchtroll.TwitchTroll;

public class BotRunner extends Thread {


    public BotRunner(){ };

    public void run(){
        try{

            getBotGoing();
        }catch (Exception e)
        {
            // Throwing an exception
            TwitchTroll.LOGGER.error("UNABLE TO START");
            System.out.println ("Exception is caught");
        }
    }



    private static void getBotGoing(){
        BotManager bot = new BotManager();
        bot.connect();

        Channel channel = bot.joinChannel("#mattemactics");
        bot.sendMessage("beep boop", channel);
        bot.start();
    }
}
