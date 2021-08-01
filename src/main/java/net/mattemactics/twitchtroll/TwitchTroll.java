package net.mattemactics.twitchtroll;


import net.mattemactics.twitchtroll.client.render.RenderGuiHandler;
import net.mattemactics.twitchtroll.client.screens.ConfigScreen;
import net.mattemactics.twitchtroll.client.util.ModSettings;
import net.mattemactics.twitchtroll.core.init.BlockInit;
import net.mattemactics.twitchtroll.core.init.ItemInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TwitchTroll.modId)
@Mod.EventBusSubscriber(Dist.CLIENT)
public class TwitchTroll
{

    public static final String modId = "twitchtroll";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public TwitchTroll() {
        //Registration.register();
        // Register the setup method for modloading
        ModSettings.LOAD();



        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
        //BotRunner bot = new BotRunner();
        //bot.start();

        //load in config screen
        ModLoadingContext.get().registerExtensionPoint(
                ExtensionPoint.CONFIGGUIFACTORY,
                () -> (mc, screen) -> new ConfigScreen()
        );
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);





        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }




    private void setup(final FMLCommonSetupEvent event)
    {

    }



}
