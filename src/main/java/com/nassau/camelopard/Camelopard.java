package com.nassau.camelopard;

import com.nassau.camelopard.common.CommandCamelopard;
import com.nassau.camelopard.common.CommonProxy;
import com.nassau.camelopard.network.PacketExtendedPlayerSync;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.command.ICommand;

@Mod(modid = Camelopard.MODID, name = Camelopard.NAME, version = Camelopard.VERSION)
public class Camelopard
{
    public static final String MODID = "camelopard";
    public static final String NAME = "Camelopard";
    public static final String VERSION = "0.1";
    
    @SidedProxy(clientSide = "com.nassau.camelopard.client.ClientProxy", serverSide = "com.nassau.camelopard.common.CommonProxy")
    public static CommonProxy proxy;
    
    @Instance("camelopard")
    public static Camelopard instance;
    
    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel("camelopard");
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	CHANNEL.registerMessage(PacketExtendedPlayerSync.Handler.class, PacketExtendedPlayerSync.class, 0, Side.SERVER);
    	CHANNEL.registerMessage(PacketExtendedPlayerSync.Handler.class, PacketExtendedPlayerSync.class, 1, Side.CLIENT);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.registerEvents();
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand((ICommand)new CommandCamelopard());
    }
}
