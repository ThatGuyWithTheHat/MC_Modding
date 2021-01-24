package net.mattemactics.testmod.core.util;

import net.mattemactics.testmod.TestMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(Dist.CLIENT)
public class WorldLoadListener {
    public static BotRunner bot = new BotRunner();
    static Boolean on = false;

    @SubscribeEvent
    public static void onWorldLoad(PlayerEvent.PlayerLoggedInEvent event)
    {
        if(!on) {
            //Minecraft.getInstance().player.sendChatMessage("PLayer login");
            TestMod.LOGGER.info("!!!!!!!!!!!!Player login!!!!!!!!!!!");
            bot.setDaemon(true);
            bot.start();
            on = true;

        }
    }
}
