package com.nassau.camelopard.common;

import com.nassau.camelopard.Camelopard;
import com.nassau.camelopard.network.PacketExtendedPlayerSync;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {

	private static final String EXT_PROP_NAME = "CamelopardExtendedPlayer";
	
	private int kamuiLevel;
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	public ExtendedPlayer(EntityPlayer player) {
		kamuiLevel = 0;
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound props = new NBTTagCompound();
		props.setInteger("KamuiLevel", this.kamuiLevel);
		compound.setTag(EXT_PROP_NAME, (NBTBase) props);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		if (compound.hasKey("CamelopardExtendedPlayer")) {
			NBTTagCompound props = (NBTTagCompound) compound.getCompoundTag(EXT_PROP_NAME);
			this.kamuiLevel = props.getInteger("KamuiLevel");
		}
	}

	@Override
	public void init(Entity entity, World world) {}
	
	public void setKamuiLevel(int kamuiLevel) {
		this.kamuiLevel = kamuiLevel;
	}

	public int getKamuiLevel() {
		return kamuiLevel;
	}
	
	public void sync(EntityPlayer player) {
		ExtendedPlayer ex = ExtendedPlayer.get(player);
		PacketExtendedPlayerSync packet = new PacketExtendedPlayerSync(ex);
		Camelopard.CHANNEL.sendTo(packet, (EntityPlayerMP) player);
	}

}
