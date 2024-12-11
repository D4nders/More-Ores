package com.danders.moreores.item;

import com.danders.moreores.MoreOres;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreOres.MODID);

    public static final DeferredItem<Item> RAW_LUMEN = ITEMS.register("raw_lumen",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_INFERNIUM = ITEMS.register("raw_infernium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LUMEN_INGOT = ITEMS.register("lumen_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INFERNIUM_INGOT = ITEMS.register("infernium_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
