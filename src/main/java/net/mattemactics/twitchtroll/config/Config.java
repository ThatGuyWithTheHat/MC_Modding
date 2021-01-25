package net.mattemactics.twitchtroll.config;


import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.mattemactics.twitchtroll.TwitchTroll;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {
    private static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec config;

    static{
        config = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path){
        TwitchTroll.LOGGER.info("loading config");
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        TwitchTroll.LOGGER.info("built config " + path);
        file.load();
        TwitchTroll.LOGGER.info("loaded config " + path);
        config.setConfig(file);
    }
}
