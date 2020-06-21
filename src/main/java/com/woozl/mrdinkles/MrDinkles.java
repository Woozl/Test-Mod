package com.woozl.mrdinkles;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.woozl.mrdinkles.init.BlockInit;
import com.woozl.mrdinkles.init.ItemInit;
import com.woozl.mrdinkles.world.gen.OreGen;

@Mod("mrdinkles")
@Mod.EventBusSubscriber(modid = MrDinkles.MOD_ID, bus = Bus.MOD)
public class MrDinkles {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mrdinkles";
    public static MrDinkles instance;

    public MrDinkles() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        OreGen.generateOre();
    }

    public static class DinklesItemGroup extends ItemGroup {
        public static final DinklesItemGroup instance = new DinklesItemGroup(ItemGroup.GROUPS.length, "mr_dinkles_tab");
        private DinklesItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.example_block);
        }
    }
}

