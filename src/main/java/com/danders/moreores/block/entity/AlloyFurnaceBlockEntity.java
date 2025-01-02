package com.danders.moreores.block.entity;

import com.danders.moreores.block.ModBlockEntityTypes;
import com.danders.moreores.block.custom.AlloyFurnaceBlock;
import com.danders.moreores.item.ModItems;
import com.danders.moreores.recipe.AlloySmeltingRecipe;
import com.danders.moreores.recipe.AlloySmeltingRecipeInput;
import com.danders.moreores.recipe.ModRecipes;
import com.danders.moreores.screen.custom.AlloyFurnaceMenu;
import com.danders.moreores.util.FuelValues;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AlloyFurnaceBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            if (!level.isClientSide()) {
                setChanged();
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int SLOT_INPUT_1 = 0;
    private static final int SLOT_INPUT_2 = 1;
    private static final int SLOT_FUEL = 2;
    private static final int SLOT_OUTPUT = 3;

    private static final String INVENTORY_KEY = "inventory";
    private static final String LIT_TIME_KEY = "alloy_furnace.lit_time";
    private static final String LIT_DURATION_KEY = "alloy_furnace.lit_duration";
    private static final String COOKING_PROGRESS_KEY = "alloy_furnace.cooking_progress";
    private static final String COOKING_TOTAL_TIME_KEY = "alloy_furnace.cooking_total_time";

    private static final int TOTAL_COOKING_TIME = 200;

    private int litTime;
    private int litDuration;
    private int cookingProgress;
    private int cookingTotalTime = TOTAL_COOKING_TIME;
    private final ContainerData data;

    public AlloyFurnaceBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.ALLOY_FURNACE_BE.get(), pos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> AlloyFurnaceBlockEntity.this.cookingProgress;
                    case 1 -> AlloyFurnaceBlockEntity.this.cookingTotalTime;
                    case 2 -> AlloyFurnaceBlockEntity.this.litTime;
                    case 3 -> AlloyFurnaceBlockEntity.this.litDuration;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: AlloyFurnaceBlockEntity.this.cookingProgress = value;
                    case 1: AlloyFurnaceBlockEntity.this.cookingTotalTime = value;
                    case 2: AlloyFurnaceBlockEntity.this.litTime = value;
                    case 3: AlloyFurnaceBlockEntity.this.litDuration = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.moreores.alloy_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new AlloyFurnaceMenu(containerId, playerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put(INVENTORY_KEY, itemHandler.serializeNBT(registries));
        tag.putInt(LIT_TIME_KEY, litTime);
        tag.putInt(LIT_DURATION_KEY, litDuration);
        tag.putInt(COOKING_PROGRESS_KEY, cookingProgress);
        tag.putInt(COOKING_TOTAL_TIME_KEY, cookingTotalTime);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound(INVENTORY_KEY));
        litTime = tag.getInt(LIT_TIME_KEY);
        litDuration = tag.getInt(LIT_DURATION_KEY);
        cookingProgress = tag.getInt(COOKING_PROGRESS_KEY);
        cookingTotalTime = tag.getInt(COOKING_TOTAL_TIME_KEY);
    }

    public void clearContents() {
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        boolean wasLit = state.getValue(AlloyFurnaceBlock.LIT);
        boolean isLit = isLit();

        if (isLit()) {
            litTime--;
        }

        if(hasRecipe() && isOutputSlotEmptyOrReceivable()) {
            if (!isLit && isFuel(itemHandler.getStackInSlot(SLOT_FUEL))) {
                litTime = getBurnDuration(itemHandler.getStackInSlot(SLOT_FUEL));
                litDuration = litTime;
                removeFuel();
                isLit = true;
            }

            if (isLit) {
                increaseSmeltingProgress();
                if (hasSmeltingFinished()) {
                    smeltItem();
                    resetProgress();
                }
            } else {
                cookingProgress = 0;
            }
        } else {
            cookingProgress = 0;
        }

        if (wasLit != isLit) {
            level.setBlockAndUpdate(pos, state.setValue(AlloyFurnaceBlock.LIT, isLit));
            setChanged(level, pos, state);
        }
    }

    private void removeFuel() {
        if (itemHandler.getStackInSlot(SLOT_FUEL).hasCraftingRemainingItem())
            itemHandler.setStackInSlot(SLOT_FUEL, new ItemStack(itemHandler.getStackInSlot(SLOT_FUEL).getCraftingRemainingItem().getItem()));
        else if (itemHandler.getStackInSlot(SLOT_FUEL).getCount() > 1)
            itemHandler.getStackInSlot(SLOT_FUEL).shrink(1);
        else itemHandler.setStackInSlot(SLOT_FUEL, ItemStack.EMPTY);
    }

    private int getBurnDuration(ItemStack stackInSlot) {
        return FuelValues.getFuelValue(stackInSlot);
    }

    private boolean isFuel(ItemStack stackInSlot) {
        return getBurnDuration(stackInSlot) > 0;
    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    private void resetProgress() {
        this.cookingProgress = 0;
        this.cookingTotalTime = TOTAL_COOKING_TIME;
    }

    private void smeltItem() {
        Optional<RecipeHolder<AlloySmeltingRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().getResultItem(null);

        itemHandler.extractItem(SLOT_INPUT_1, 1, false);
        itemHandler.extractItem(SLOT_INPUT_2, 1, false);

        itemHandler.setStackInSlot(SLOT_OUTPUT, new ItemStack(output.getItem(), itemHandler.getStackInSlot(SLOT_OUTPUT).getCount() + output.getCount()));
    }

    private boolean hasSmeltingFinished() {
        return this.cookingProgress >= this.cookingTotalTime;
    }

    private void increaseSmeltingProgress() {
        cookingProgress++;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty() || this.itemHandler.getStackInSlot(SLOT_OUTPUT).getCount() < this.itemHandler.getStackInSlot(SLOT_OUTPUT).getMaxStackSize();
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<AlloySmeltingRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().getResultItem(null);

        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<AlloySmeltingRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager().getRecipeFor(ModRecipes.ALLOY_FURNACE_TYPE.get(), new AlloySmeltingRecipeInput(itemHandler.getStackInSlot(SLOT_INPUT_1), itemHandler.getStackInSlot(SLOT_INPUT_2)), level);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty() || itemHandler.getStackInSlot(SLOT_OUTPUT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty() ? 64 : itemHandler.getStackInSlot(SLOT_OUTPUT).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(SLOT_OUTPUT).getCount();

        return maxCount >= currentCount + count;
    }
}
