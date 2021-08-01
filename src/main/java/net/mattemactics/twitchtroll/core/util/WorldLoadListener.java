package net.mattemactics.twitchtroll.core.util;

import net.mattemactics.twitchtroll.TwitchTroll;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;


@Mod.EventBusSubscriber(Dist.CLIENT)
public class WorldLoadListener {
    public static BotRunner bot = new BotRunner();
    static Boolean on = false;

    @SubscribeEvent
    public static void onWorldLoad(PlayerEvent.PlayerLoggedInEvent event)
    {
        if(!on) {

            TwitchTroll.LOGGER.info("!!!!!!!!!!!!Player login!!!!!!!!!!!");
            bot.setDaemon(true);
            bot.start();
            on = true;
        }
    }

    @SubscribeEvent
    public static void onGameExit(FMLServerStoppingEvent event){

        BotManager.SAVE();

    }
}
