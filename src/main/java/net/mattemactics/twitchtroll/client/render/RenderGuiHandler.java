package net.mattemactics.twitchtroll.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.mattemactics.twitchtroll.core.util.TwitchViewer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RenderGuiHandler {
    static int yOffset = 20;

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Text event) {

        HashMap<String, Integer> cost = (HashMap<String, Integer>) TwitchViewer.getCommandCost();
        FontRenderer render= Minecraft.getInstance().fontRenderer;



        render.drawStringWithShadow(new MatrixStack(), "Command List", 10,10,0xba03fc);
        yOffset = 20;
        boolean colorChange = false;
        int color = 0x72C991;
        ArrayList<String> costKeys = new ArrayList<>(cost.keySet());
        Collections.sort(costKeys);
        for(String key: costKeys){
            if(colorChange) color = 0x72C991;
            else color = 0x6a6cc4;
            render.drawStringWithShadow(new MatrixStack(), key, 10,yOffset,color);
            render.drawStringWithShadow(new MatrixStack(), cost.get(key).toString(), 70,yOffset,color);
            yOffset = yOffset + 10;
            colorChange = !colorChange;
        }
    }

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {

        AbstractGui.fill(new MatrixStack(), 5,5,100,yOffset,0x0F494949);
    }




}
