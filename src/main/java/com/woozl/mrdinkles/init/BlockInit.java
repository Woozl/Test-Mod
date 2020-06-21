package com.woozl.mrdinkles.init;

import com.woozl.mrdinkles.MrDinkles;
import com.woozl.mrdinkles.MrDinkles.DinklesItemGroup;
import com.woozl.mrdinkles.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@ObjectHolder(MrDinkles.MOD_ID)
@Mod.EventBusSubscriber(modid = MrDinkles.MOD_ID, bus = Bus.MOD)
public class BlockInit {
    public static final Block example_block = null;
    public static final Block special_block = null;
    
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(new Material.Builder(MaterialColor.STONE).build()).hardnessAndResistance(1.5F, 6.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE).lightValue(15)).setRegistryName("example_block"));
        event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 10.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).lightValue(3).slipperiness(1.2F).speedFactor(0.7F).noDrops()).setRegistryName("special_block"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(example_block, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("example_block"));
        event.getRegistry().register(new BlockItem(special_block, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("special_block"));
    }
}