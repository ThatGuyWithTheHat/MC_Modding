package net.mattemactics.testmod.core.util;


import com.cavariux.twitchirc.Chat.Channel;
import com.cavariux.twitchirc.Chat.User;
import com.cavariux.twitchirc.Core.TwitchBot;
import java.util.concurrent.Semaphore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BotManager extends TwitchBot {

    ArrayList<String> commands = new ArrayList<String>();
    Map<String,TwitchViewer> viewers = new HashMap<>();
    static Semaphore semaphore = new Semaphore(1);



    public static BlockingQueue<String> spawn = new LinkedBlockingQueue<>();



    public static String getSpawn(){
        String out = null;
        try {
            semaphore.acquire();
            out = spawn.poll();
            semaphore.release();
        }catch(Exception e){
            out = null;
        }
        return out; //will return null if empty
    }


    public void processCommand(User user, Channel channel, String message) {
        String userName = user.toString();
        String callMsg = userName + " has deployed ";

        //this.sendMsg(message, channel);
        if (viewers.get(userName).costPoints(message.toLowerCase()) || user.isMod(channel)) {


            if (message.equalsIgnoreCase("!coin")) {
                callMsg = user.toString() + " has " + viewers.get(userName).getPoints().toString() + " Troll Coins";
                this.sendMsg(callMsg, channel);
            } else if (viewers.get(userName).onCommandList(message)) {

                String spawnMsg = userName + message;
                callMsg = callMsg + " has deployed ";
                callMsg = callMsg + message.replace("!", "");
                this.sendMsg(callMsg, channel);
                try {
                    semaphore.acquire();
                    spawn.add(spawnMsg);
                    semaphore.release();
                }catch(Exception e){

                }

            }


        }
    }


    public void sendMsg(String msg, Channel channel){
        this.sendMessage(msg, channel);
    }


    @Override
    public void onMessage(User user, Channel channel, String message)
    {
        if(viewers.isEmpty()){viewers.put(user.toString(), new TwitchViewer(user.toString()));}
        if(!viewers.containsKey(user.toString())){
            viewers.put(user.toString(), new TwitchViewer(user.toString()));
        }
        if(message.contains("!")) this.processCommand(user, channel, message);
        viewers.get(user.toString()).pointsIncrease();
    }





    public BotManager() {
        this.setUsername("mattemactics");
        this.setOauth_Key(Secrets.AUTH);


        commands.add("!creeper");
        commands.add("!zombie");
        commands.add("!skeleton");
        commands.add("!tnt");
        commands.add("!ghast");
        commands.add("!anvil");
        commands.add("!coin");

    }



}


