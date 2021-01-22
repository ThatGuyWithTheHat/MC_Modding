package net.mattemactics.testmod;


import net.mattemactics.testmod.core.init.BlockInit;
import net.mattemactics.testmod.core.init.ItemInit;
import net.mattemactics.testmod.core.util.BotRunner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod.modId)
@Mod.EventBusSubscriber(Dist.CLIENT)
public class TestMod
{
    public static final String modId = "testmod";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public TestMod() {
        //Registration.register();
        // Register the setup method for modloading
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        BotRunner bot = new BotRunner();
        bot.start();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);





        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event)
    {

    }



}
