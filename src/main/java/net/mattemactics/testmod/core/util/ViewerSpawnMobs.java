package net.mattemactics.testmod.core.util;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
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
            if (command.equalsIgnoreCase("creeper")) spawnCreeper(name, event.player.world, event.player);
            if (command.equalsIgnoreCase("skelly")) spawnSkeleton(name, event.player.world, event.player);
            if (command.equalsIgnoreCase("tnt")) spawnTNT(event.player.world, event.player);
            if (command.equalsIgnoreCase("anvil")) spawnAnvil(event.player.world, event.player);
            if (command.equalsIgnoreCase("ghast")) spawnGhast(name, event.player.world, event.player);
            if (command.equalsIgnoreCase("fire")) spawnFire(event.player.world, event.player);
        }

    }

    public static void updateMSG(String username, String item){
        String msg = username + " has deployed " + item;
        Minecraft.getInstance().player.sendChatMessage(msg);
    }


    public static void spawnZombie(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Zombie";

        ZombieEntity zom = new ZombieEntity(worldIn);
        zom.setCustomName(new StringTextComponent(userName));
        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        zom.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
        worldIn.addEntity(zom);
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


    public static void spawnSkeleton(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Skelly";

        SkeletonEntity skelly = new SkeletonEntity(EntityType.SKELETON, worldIn);
        skelly.setCustomName(new StringTextComponent(userName));

        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        skelly.setPosition(playerIn.getPosX() + xOffset, playerIn.getPosY(), playerIn.getPosZ() + zOffset);
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



        worldIn.setBlockState(playerIn.getPosition().up(3), Blocks.TNT.getDefaultState());
        worldIn.setBlockState(playerIn.getPosition().up(4), Blocks.FIRE.getDefaultState());
        //worldIn.notifyBlockUpdate();

    }

    public static void spawnAnvil(World worldIn, PlayerEntity playerIn){
        worldIn.setBlockState(playerIn.getPosition().up(10), Blocks.ANVIL.getDefaultState());
        //worldIn.up
    }

    public static void spawnFire(World worldIn, PlayerEntity playerIn){
        worldIn.setBlockState(playerIn.getPosition(), Blocks.FIRE.getDefaultState());
    }



}
