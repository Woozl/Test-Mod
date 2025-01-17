package com.woozl.mrdinkles.init;

import com.woozl.mrdinkles.MrDinkles;
import com.woozl.mrdinkles.MrDinkles.DinklesItemGroup;
import com.woozl.mrdinkles.objects.items.SpecialItem;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = MrDinkles.MOD_ID, bus = Bus.MOD)
@ObjectHolder(MrDinkles.MOD_ID)
public class ItemInit {
    public static final Item example_item = null;
    public static final Item la_croix = null;
    public static final Item special_item = null;

    public static final Item example_sword = null;
    public static final Item example_pickaxe = null;
    public static final Item example_shovel = null;
    public static final Item example_axe = null;
    public static final Item example_hoe = null;

    public static final Item dinkles_helmet = null;
    public static final Item dinkles_chestplate = null;
    public static final Item dinkles_leggings = null;
    public static final Item dinkles_boots = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("example_item"));
        event.getRegistry().register(new Item(new Item.Properties().group(DinklesItemGroup.instance).food(new Food.Builder().hunger(6).saturation(14.4F).setAlwaysEdible().effect(new EffectInstance(Effects.ABSORPTION, 600, 5), 1.0F).build())).setRegistryName("la_croix"));
        event.getRegistry().register(new SpecialItem(new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("special_item"));
        
        event.getRegistry().register(new SwordItem(DinklesItemTier.EXAMPLE, 7, 5.0F, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("example_sword"));
        event.getRegistry().register(new PickaxeItem(DinklesItemTier.EXAMPLE, 4, 5.0F, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("example_pickaxe"));
        event.getRegistry().register(new ShovelItem(DinklesItemTier.EXAMPLE, 2, 5.0F, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("example_shovel"));
        event.getRegistry().register(new AxeItem(DinklesItemTier.EXAMPLE, 11, 3.0F, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("example_axe"));
        event.getRegistry().register(new HoeItem(DinklesItemTier.EXAMPLE, 5.0F, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("example_hoe"));
        
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("dinkles_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("dinkles_chestplate"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("dinkles_leggings"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(DinklesItemGroup.instance)).setRegistryName("dinkles_boots"));
    }
    
    public enum DinklesItemTier implements IItemTier {
        EXAMPLE(4, 3000, 15.0F, 7.0F, 150, () -> {
            return Ingredient.fromItems(ItemInit.example_item);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private DinklesItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            this.repairMaterial.getValue();
            return null;
        }
    }

    public enum ModArmorMaterial implements IArmorMaterial {
		TEST(MrDinkles.MOD_ID + ":test", 5, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 7.0F, () -> {
			return Ingredient.fromItems(ItemInit.example_item);
		});

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }
}