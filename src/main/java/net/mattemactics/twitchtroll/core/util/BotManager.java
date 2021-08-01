package net.mattemactics.twitchtroll.core.util;


import com.cavariux.twitchirc.Chat.Channel;
import com.cavariux.twitchirc.Chat.User;
import com.cavariux.twitchirc.Core.TwitchBot;
import net.mattemactics.twitchtroll.client.util.FileManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class BotManager extends TwitchBot {

    static String FILENAME = "viewers.csv";


    ArrayList<String> commands = new ArrayList<String>();
    public static Map<String,TwitchViewer> viewers = new HashMap<>();
    public static ArrayList<String> CHATLOG = new ArrayList<String>();
    static Semaphore semaphore = new Semaphore(1);
    private static boolean RUN = true;



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

    public static void addSpawn(String command){

        try {
            semaphore.acquire();
            spawn.add(command);
            semaphore.release();
        }catch(Exception e){

        }

    }


    public void processCommand(User user, Channel channel, String message) {
        String userName = user.toString();
        String callMsg = userName + " has deployed ";

        //if(user.isMod(channel)) sendMsg("you are a mod", channel);

        //this.sendMsg(message, channel);
        if (viewers.get(userName).costPoints(message.toLowerCase()) || user.isMod(channel)) {


            if (message.equalsIgnoreCase("!coin")) {
                callMsg = user.toString() + " has " + viewers.get(userName).getPoints().toString() + " Troll Coins";
                this.sendMsg(callMsg, channel);
            } else if (viewers.get(userName).onCommandList(message)) {

                String spawnMsg = userName + message;
                callMsg = callMsg;
                callMsg = callMsg + message.replace("!", "");
                this.sendMsg(callMsg, channel);
                addSpawn(spawnMsg);

            } else if (message.contains("!give") && (user.isMod(channel) || userName.equalsIgnoreCase("mattemactics"))) {

                try{
                    String[] msg = message.split(" ");
                    viewers.get(msg[1]).givePoints(Integer.parseInt(msg[2]));
                } catch(Exception e){
                    this.sendMsg("@" + userName + " the give command is !give <username> <points>", channel);

                }

            }


        } else this.sendMsg(userName + " you do not have enough coins", channel);
    }

    public static void refund(String userName, String command){
        viewers.get(userName).refundPoints("!" + command);
    }


    public void sendMsg(String msg, Channel channel){
        this.sendMessage(msg, channel);
    }

    public static void SAVE(){
        ArrayList<String> saveData = new ArrayList<String>();

        for(String key: viewers.keySet()){
            StringBuilder build = new StringBuilder();
            build.append(key);
            build.append(',');
            build.append(viewers.get(key).getPoints());
            saveData.add(build.toString());
        }
        FileManager file = new FileManager(FILENAME);
        file.writeFile(saveData);


        //save chatlog if it exists
        if(!CHATLOG.isEmpty()) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            StringBuilder fileNameBuilder = new StringBuilder();
            fileNameBuilder.append("CHATLOG-");
            fileNameBuilder.append(timeStamp);
            fileNameBuilder.append(".csv");
            FileManager chatLog = new FileManager(fileNameBuilder.toString());
            chatLog.writeFile(CHATLOG);
        }

        CHATLOG.removeAll(CHATLOG);

    }

    public static void LOAD(){
        FileManager file = new FileManager(FILENAME);
        ArrayList<String> fileData = file.readFile();
        if(fileData.isEmpty()) return;
        for(String s: fileData){
            String key = s.split(",")[0];
            int value = Integer.parseInt(s.split(",")[1]);
            viewers.put(key, new TwitchViewer(key, value));
        }



        TwitchViewer.updateCommandCost();

    }


    @Override
    public void onMessage(User user, Channel channel, String message)
    {
        StringBuilder s = new StringBuilder();
        s.append(user.toString());
        s.append(":    ");
        s.append(message);
        s.append("\n");
        CHATLOG.add(s.toString());
        if(CHATLOG.size()>50){
            BotManager.SAVE();

        }


        if(viewers.isEmpty()){viewers.put(user.toString(), new TwitchViewer(user.toString()));}
        if(!viewers.containsKey(user.toString())){
            viewers.put(user.toString(), new TwitchViewer(user.toString()));
        }
        if(message.startsWith("!")) this.processCommand(user, channel, message);
        viewers.get(user.toString()).pointsIncrease();
    }


    public void go(){
        this.RUN = true;
    }

    public void stop(){
        this.RUN = false;
    }

    public BotManager() {
        BotManager.LOAD();
        this.setUsername("mattemactics");
        this.setOauth_Key(Secrets.AUTH);
    }



}


