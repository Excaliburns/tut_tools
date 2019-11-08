package com.tut.tuttools;

import com.tut.tuttools.blocks.ToolBlock;
import com.tut.tuttools.blocks.TutBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    //Register Blocks

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
        // register a new block here
        event.getRegistry().register(new ToolBlock());
    }

    //Register Items

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(TutBlocks.FIRSTBLOCK, new Item.Properties()).setRegistryName("toolblock"));
    }
}