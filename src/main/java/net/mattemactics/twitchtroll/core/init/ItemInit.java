package net.mattemactics.twitchtroll.core.init;

import net.mattemactics.twitchtroll.TwitchTroll;
import net.mattemactics.twitchtroll.common.items.SpecailItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TwitchTroll.modId);

    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("item_name",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<BlockItem> EXAMPLE_BLOCK = ITEMS.register("block_name",
            () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<SpecailItem> SPECAIL_ITEM = ITEMS.register("specail_item",
            () -> new SpecailItem(new Item.Properties().group(ItemGroup.MISC)));
}
