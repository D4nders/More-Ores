package com.danders.moreores.block;

import com.danders.moreores.MoreOres;
import com.danders.moreores.block.entity.AlloyFurnaceBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MoreOres.MODID);

    public static final Supplier<BlockEntityType<AlloyFurnaceBlockEntity>> ALLOY_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("alloy_furnace_entity",
            () -> BlockEntityType.Builder.of(
                            AlloyFurnaceBlockEntity::new,
                            ModBlocks.ALLOY_FURNACE.get()
                    )
                    .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
