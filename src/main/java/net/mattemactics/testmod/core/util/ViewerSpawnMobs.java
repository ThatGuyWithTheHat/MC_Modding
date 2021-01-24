package net.mattemactics.testmod.core.util;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;


@Mod.EventBusSubscriber(Dist.CLIENT)
public class ViewerSpawnMobs extends Event {

    static Integer spawnRandomize = 5;




    @SubscribeEvent
    public static void onPlayerTickEvent(TickEvent.PlayerTickEvent event){

        //System.out.println("tick");
        String spawn = BotManager.getSpawn();
        if(spawn != null) {
            ArrayList<String> commandList = new ArrayList<String>();
            String name = spawn.split("!")[0];
            String command = spawn.split("!")[1];
            updateMSG(name, command);
            if (command.equalsIgnoreCase("zombie")) spawnZombie(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("creeper")) spawnCreeper(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("skelly")) spawnSkeleton(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("tnt")) spawnTNT(event.player.world, event.player);
            else if (command.equalsIgnoreCase("anvil")) spawnAnvil(event.player.world, event.player);
            else if (command.equalsIgnoreCase("ghast")) spawnGhast(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("fire")) spawnFire(event.player.world, event.player);
            else if (command.equalsIgnoreCase("goodboy")) spawnDog(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("dropit")) dropIt(event.player.world, event.player);
            else if (command.equalsIgnoreCase("boom")) spawnChargedCreeper(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("enderman")) spawnEnderman(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("blaze")) spawnBlaze(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("bees")) spawnBees(name, event.player.world, event.player);


        }

    }

    public static void updateMSG(String username, String item){
        String msg = username + " has deployed " + item;
        Minecraft.getInstance().player.sendChatMessage(msg);
    }


    public static ZombieEntity spawnZombie(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Zombie";

        ZombieEntity zom = new ZombieEntity(worldIn);
        zom.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        zom.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        worldIn.addEntity(zom);
        return zom;
    }

    public static void spawnEnderman(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Enderman";

        EndermanEntity enderman = new EndermanEntity(EntityType.ENDERMAN, worldIn);
        enderman.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        enderman.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        worldIn.addEntity(enderman);

    }

    public static void spawnBlaze(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "blaze";

        BlazeEntity blaze = new BlazeEntity(EntityType.BLAZE, worldIn);
        blaze.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        blaze.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        worldIn.addEntity(blaze);

    }


    public static void spawnBees(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "blaze";

        for(int i = 0; i < 3; i++) {
            BeeEntity bee = new BeeEntity(EntityType.BEE, worldIn);
            bee.setCustomName(new StringTextComponent(userName));
            int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize, spawnRandomize);
            int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize, spawnRandomize);
            bee.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
            worldIn.addEntity(bee);
        }

    }




    public static void spawnCreeper(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Creeper";

        CreeperEntity creep = new CreeperEntity(EntityType.CREEPER, worldIn);
        creep.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        creep.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        worldIn.addEntity(creep);
    }

    public static void spawnChargedCreeper(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Creeper";


        CreeperEntity creep = new CreeperEntity(EntityType.CREEPER, worldIn);
        creep.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        creep.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        worldIn.addEntity(creep);

        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, worldIn);
        bolt.setPosition(creep.getPosX(), creep.getPosY(), creep.getPosZ());
        worldIn.addEntity(bolt);

    }


    public static void spawnSkeleton(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Skelly";

        SkeletonEntity skelly = new SkeletonEntity(EntityType.SKELETON, worldIn);
        skelly.setCustomName(new StringTextComponent(userName));

        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        skelly.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        skelly.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.BOW));
        worldIn.addEntity(skelly);
    }

    public static void spawnGhast(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Ghast";

        GhastEntity ghast = new GhastEntity(EntityType.GHAST, worldIn);
        ghast.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        ghast.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY() + 5, playerIn.getPosZ() + zOffset);
        worldIn.addEntity(ghast);
    }

    public static void spawnTNT(World worldIn, PlayerEntity playerIn){
        String entityName = "TNT";
        worldIn.setBlockState(playerIn.getPosition().up(3), Blocks.TNT.getDefaultState(),1);
        worldIn.setBlockState(playerIn.getPosition().up(4), Blocks.FIRE.getDefaultState(),1);
        //worldIn.notifyBlockUpdate();

    }

    public static void spawnAnvil(World worldIn, PlayerEntity playerIn){
        worldIn.setBlockState(playerIn.getPosition().up(10), Blocks.ANVIL.getDefaultState(),1);

        //worldIn.up
    }

    public static void spawnFire(World worldIn, PlayerEntity playerIn){
        playerIn.setFire(5);
    }

    public static void dropItAll(World worldIn, PlayerEntity playerIn){
        playerIn.inventory.dropAllItems();
    }

    public static void dropIt(World worldIn, PlayerEntity playerIn){
        playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());

    }



    public static void spawnDog(String userName, World worldIn, PlayerEntity playerIn){
        WolfEntity wolf = new WolfEntity(EntityType.WOLF, worldIn);
        wolf.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        wolf.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        worldIn.addEntity(wolf);
        wolf.setTamedBy(playerIn);
    }



}
