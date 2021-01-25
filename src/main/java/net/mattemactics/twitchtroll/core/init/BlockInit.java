package net.mattemactics.twitchtroll.core.init;

import net.mattemactics.twitchtroll.TwitchTroll;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TwitchTroll.modId);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("block_name",
            () -> new Block(AbstractBlock.Properties
                    .create(Material.IRON, MaterialColor.BLUE).hardnessAndResistance(15,30)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(-1).sound(SoundType.CLOTH)
                    .setRequiresTool()));
}