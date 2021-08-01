package net.mattemactics.twitchtroll.client.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private String fileName;
    File file;
    public static ArrayList<String> fileData= new ArrayList<String>();

    public FileManager(String name){
        this.fileName = name;
        file = new File(this.fileName);
        try{
            if(!file.createNewFile()){
                this.readFile();
            }

        }catch(IOException e){
            System.out.println("unable to open file");
            e.printStackTrace();
        }
    }

    public void writeFile(ArrayList<String> dataToWrite) {
        try {

            FileWriter writer = new FileWriter(this.fileName);
            for(String s: dataToWrite){
                writer.write(s + "\n");
            }
            writer.close();
            System.out.println(file.getAbsolutePath());
        }catch(IOException e){
            System.out.println("unable to write file");
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFile(){
        try{
            Scanner reader = new Scanner(this.file);
            while (reader.hasNextLine()){
                String data = reader.nextLine();
                this.fileData.add(data);
            }

            reader.close();


        } catch (FileNotFoundException e) {
            System.out.println("unable to read file");
            e.printStackTrace();
        }
        return this.fileData;
    }
}
