package net.mattemactics.testmod.config;


import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.mattemactics.testmod.TestMod;
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
        TestMod.LOGGER.info("loading config");
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        TestMod.LOGGER.info("built config " + path);
        file.load();
        TestMod.LOGGER.info("loaded config " + path);
        config.setConfig(file);
    }
}
