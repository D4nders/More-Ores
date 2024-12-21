package com.danders.moreores.item;

import com.danders.moreores.MoreOres;
import com.danders.moreores.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreOres.MODID);

    public static final DeferredItem<Item> RAW_LUMEN = ITEMS.register("raw_lumen",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_INFERNIUM = ITEMS.register("raw_infernium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_NECROTHITE = ITEMS.register("raw_necrothite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_INANIS = ITEMS.register("raw_inanis",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LUMEN_INGOT = ITEMS.register("lumen_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INFERNIUM_INGOT = ITEMS.register("infernium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NECROTHITE_INGOT = ITEMS.register("necrothite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INANIS_INGOT = ITEMS.register("inanis_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> LUMEN_SWORD = ITEMS.register("lumen_sword",
            () -> new SwordItem(ModToolTiers.LUMEN, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.LUMEN, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> LUMEN_PICKAXE = ITEMS.register("lumen_pickaxe",
            () -> new PickaxeItem(ModToolTiers.LUMEN, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.LUMEN, 1.0f, -2.8f))));
    public static final DeferredItem<AxeItem> LUMEN_AXE = ITEMS.register("lumen_axe",
            () -> new AxeItem(ModToolTiers.LUMEN, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.LUMEN, 1.5f, -3.0f))));
    public static final DeferredItem<ShovelItem> LUMEN_SHOVEL = ITEMS.register("lumen_shovel",
            () -> new ShovelItem(ModToolTiers.LUMEN, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.LUMEN, 6.0f, -3.2f))));
    public static final DeferredItem<HoeItem> LUMEN_HOE = ITEMS.register("lumen_hoe",
            () -> new HoeItem(ModToolTiers.LUMEN, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.LUMEN, 0f, -3.0f))));

    public static final DeferredItem<ArmorItem> LUMEN_HELMET = ITEMS.register("lumen_helmet",
            () -> new ModArmorItem(ModArmorMaterials.LUMEN_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> LUMEN_CHESTPLATE = ITEMS.register("lumen_chestplate",
            () -> new ArmorItem(ModArmorMaterials.LUMEN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> LUMEN_LEGGINGS = ITEMS.register("lumen_leggings",
            () -> new ArmorItem(ModArmorMaterials.LUMEN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> LUMEN_BOOTS = ITEMS.register("lumen_boots",
            () -> new ArmorItem(ModArmorMaterials.LUMEN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
