package forestry.core.gui.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import forestry.core.interfaces.ICrafter;
import forestry.core.render.TextureManager;

/**
 * Slot with an ICrafter callback.
 */
public abstract class SlotWatched extends SlotForestry {
	private ICrafter crafter;
	private String blockedTexture = "slots/blocked";

	public SlotWatched(IInventory inventory, int slotIndex, int xPos, int yPos) {
		super(inventory, slotIndex, xPos, yPos);
	}

	public SlotWatched setCrafter(ICrafter crafter) {
		this.crafter = crafter;
		return this;
	}

	@Override
	public boolean getHasStack() {
		if (crafter != null && !crafter.canTakeStack(getSlotIndex())) {
			return false;
		} else {
			return super.getHasStack();
		}
	}

	@Override
	public ItemStack decrStackSize(int i) {
		if (crafter != null && !crafter.canTakeStack(getSlotIndex())) {
			return null;
		} else {
			return super.decrStackSize(i);
		}
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack) {
		if (crafter != null) {
			crafter.takenFromSlot(getSlotIndex(), player);
		}
	}

	public SlotWatched setBlockedTexture(String ident) {
		blockedTexture = ident;
		return this;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getBackgroundIconIndex() {
		ItemStack stack = getStack();
		if (!isItemValid(stack)) {
			return TextureManager.getInstance().getDefault(blockedTexture);
		} else {
			return null;
		}
	}
}
