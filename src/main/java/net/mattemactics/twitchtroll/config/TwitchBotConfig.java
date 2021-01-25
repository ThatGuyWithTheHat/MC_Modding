package net.mattemactics.twitchtroll.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TwitchBotConfig {
    public static ForgeConfigSpec.BooleanValue on;
    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client){
        server.comment("Twitch Bot Config");
    }
}
