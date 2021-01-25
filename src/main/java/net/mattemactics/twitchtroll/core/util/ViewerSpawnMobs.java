package net.mattemactics.twitchtroll.core.util;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
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
            Boolean doesItWork = true;
            updateMSG(name, command);
            if (command.equalsIgnoreCase("zombie")) doesItWork = spawnZombie(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("creeper")) doesItWork =spawnCreeper(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("skelly")) doesItWork =spawnSkeleton(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("tnt")) spawnTNT(event.player.world, event.player);
            else if (command.equalsIgnoreCase("anvil")) spawnAnvil(event.player.world, event.player);
            else if (command.equalsIgnoreCase("ghast")) doesItWork = spawnGhast(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("fire")) spawnFire(event.player.world, event.player);
            else if (command.equalsIgnoreCase("goodboy")) doesItWork = spawnDog(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("dropit")) dropIt(event.player.world, event.player);
            else if (command.equalsIgnoreCase("boom")) spawnChargedCreeper(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("enderman")) doesItWork = spawnEnderman(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("blaze")) doesItWork = spawnBlaze(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("bees")) doesItWork = spawnBees(name, event.player.world, event.player);
            else if (command.equalsIgnoreCase("dropitall")) dropItAll(event.player.world, event.player);

            if(doesItWork) updateMSG(name, command);
            else{
                failMSG(name, command);
                BotManager.refund(name, command);
            }




        }

    }

    public static void updateMSG(String username, String item){
        String msg = username + " has deployed " + item;
        Minecraft.getInstance().player.sendChatMessage(msg);
    }

    public static void failMSG(String username, String item){
        String msg = username + " could not deploy " + item + " points refunded";
        Minecraft.getInstance().player.sendChatMessage(msg);
    }


    public static BlockPos spawnLocation(PlayerEntity playerIn, World worldIn){

        int xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        int zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize,spawnRandomize);
        while(!worldIn.isAirBlock(playerIn.getPosition().east(xOffset).north(zOffset))) {
            xOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize, spawnRandomize);
            zOffset = ModUtils.randBetweenTwoValues(-1 * spawnRandomize, spawnRandomize);
        }


        return playerIn.getPosition().east(xOffset).north(zOffset);


    }



    public static Boolean addEntityToWorld(Entity inEntity, World worldIn, PlayerEntity playerIn){
        BlockPos pos = spawnLocation(playerIn, worldIn);
        inEntity.setPosition(pos.getX(), pos.getY(), pos.getZ());
        worldIn.addEntity(inEntity);

        return inEntity.isAddedToWorld();

    }

    public static Boolean spawnZombie(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Zombie";

        ZombieEntity zom = new ZombieEntity(worldIn);
        zom.setCustomName(new StringTextComponent(userName));
        return addEntityToWorld(zom, worldIn, playerIn);

    }

    public static Boolean spawnEnderman(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Enderman";

        EndermanEntity enderman = new EndermanEntity(EntityType.ENDERMAN, worldIn);
        enderman.setCustomName(new StringTextComponent(userName));
        return addEntityToWorld(enderman, worldIn, playerIn);

    }

    public static Boolean spawnBlaze(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "blaze";

        BlazeEntity blaze = new BlazeEntity(EntityType.BLAZE, worldIn);
        blaze.setCustomName(new StringTextComponent(userName));
        return addEntityToWorld(blaze, worldIn, playerIn);

    }


    public static Boolean spawnBees(String userName, World worldIn, PlayerEntity playerIn){
        Boolean toReturn = true;
        for(int i = 0; i < 3; i++) {
            BeeEntity bee = new BeeEntity(EntityType.BEE, worldIn);
            bee.setCustomName(new StringTextComponent(userName));
            toReturn = addEntityToWorld(bee,  worldIn, playerIn);
        }

        return toReturn;

    }




    public static Boolean spawnCreeper(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Creeper";

        CreeperEntity creep = new CreeperEntity(EntityType.CREEPER, worldIn);
        creep.setCustomName(new StringTextComponent(userName));
        return addEntityToWorld(creep, worldIn, playerIn);
    }

    public static Boolean spawnChargedCreeper(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Creeper";


        CreeperEntity creep = new CreeperEntity(EntityType.CREEPER, worldIn);
        creep.setCustomName(new StringTextComponent(userName));
        Boolean toReturn = true;
        toReturn = addEntityToWorld(creep, worldIn, playerIn);

        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, worldIn);
        bolt.setPosition(creep.getPosition().getX(), creep.getPosition().getY(), creep.getPosition().getZ());
        worldIn.addEntity(bolt);
        return toReturn;

    }


    public static Boolean spawnSkeleton(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Skelly";

        SkeletonEntity skelly = new SkeletonEntity(EntityType.SKELETON, worldIn);
        skelly.setCustomName(new StringTextComponent(userName));
        skelly.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.BOW));
        return addEntityToWorld(skelly, worldIn, playerIn);
    }

    public static Boolean spawnGhast(String userName, World worldIn, PlayerEntity playerIn){
        String entityName = "Ghast";

        GhastEntity ghast = new GhastEntity(EntityType.GHAST, worldIn);
        ghast.setCustomName(new StringTextComponent(userName));
        return addEntityToWorld(ghast, worldIn, playerIn);
    }

    public static void spawnTNT(World worldIn, PlayerEntity playerIn){
        String entityName = "TNT";
        worldIn.setBlockState(playerIn.getPosition().up(3), Blocks.TNT.getDefaultState(),1);
        worldIn.setBlockState(playerIn.getPosition().up(4), Blocks.FIRE.getDefaultState(),1);
        //worldIn.notifyBlockUpdate();

    }

    public static void spawnAnvil(World worldIn, PlayerEntity playerIn){
        //todo make blocks fall
        worldIn.setBlockState(playerIn.getPosition().up(5), Blocks.ANVIL.getDefaultState(),64);



        //worldIn.up
    }

    public static void spawnFire(World worldIn, PlayerEntity playerIn){
        playerIn.setFire(2);
    }

    public static void dropItAll(World worldIn, PlayerEntity playerIn){
        playerIn.inventory.dropAllItems();
    }

    public static void dropIt(World worldIn, PlayerEntity playerIn){
        playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());

    }



    public static Boolean spawnDog(String userName, World worldIn, PlayerEntity playerIn){
        WolfEntity wolf = new WolfEntity(EntityType.WOLF, worldIn);
        wolf.setCustomName(new StringTextComponent(userName));
        BlockPos pos = spawnLocation(playerIn, worldIn);
        wolf.setPosition(pos.getX(), pos.getY(), pos.getZ());
        wolf.setTamedBy(playerIn);
        return addEntityToWorld(wolf, worldIn, playerIn);

    }



}
