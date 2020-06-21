// package com.woozl.mrdinkles.events;

// import com.woozl.mrdinkles.MrDinkles;
// import com.woozl.mrdinkles.init.BlockInit;

// import net.minecraft.entity.LivingEntity;
// import net.minecraft.potion.EffectInstance;
// import net.minecraft.potion.Effects;
// import net.minecraft.world.World;
// import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
// import net.minecraftforge.fml.common.Mod;
// import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

// @Mod.EventBusSubscriber(modid = MrDinkles.MOD_ID, bus = Bus.FORGE)
// public class TestJumpEvent {
//     @SubscribeEvent
//     public static void testJumpEvent(LivingJumpEvent event) {
//         MrDinkles.LOGGER.info("TestJumpEvent fired");
//         LivingEntity livingEntity = event.getEntityLiving();
//         World world = livingEntity.getEntityWorld();
//         world.setBlockState(livingEntity.getPosition().add(0, 3, 0), BlockInit.example_block.getDefaultState());
//         livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100));
//         livingEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 100));
//         livingEntity.setGlowing(true);
//     }
// }