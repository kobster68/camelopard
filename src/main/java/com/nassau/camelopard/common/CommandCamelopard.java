package com.nassau.camelopard.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class CommandCamelopard implements ICommand {

	private final String COMMAND_NAME = "camelopard";
	private final String COMMAND_USAGE = "/camelopard <get:set> [number]";

	private final List alias;
	
	private final List autoComplete;

	public CommandCamelopard() {
		this.alias = new ArrayList();
		this.alias.add(this.getCommandName());
		
		this.autoComplete = new ArrayList();
		this.autoComplete.add("get");
		this.autoComplete.add("set");
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return COMMAND_USAGE;
	}

	@Override
	public List getCommandAliases() {
		return alias;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if (args.length < 1) {
			sender.addChatMessage(new ChatComponentText("Usage: " + COMMAND_USAGE));
			return;
		}
		
		EntityPlayer player = sender.getEntityWorld().getPlayerEntityByName(sender.getCommandSenderName());
		
		if(args[0].equals("get")) {
			sender.addChatMessage(new ChatComponentText("Kamui level: " + ExtendedPlayer.get(player).getKamuiLevel()));
			return;
		}
		if(args[0].equals("set")) {
			if (args.length < 2) {
				sender.addChatMessage(new ChatComponentText("Please enter an integer"));
				return;
			}
			
			int level;
			
			try {
				level = Integer.parseInt(args[1]);
			} catch(NumberFormatException e) {
				sender.addChatMessage(new ChatComponentText("Please enter an integer"));
				return;
			}
	
			ExtendedPlayer.get(player).setKamuiLevel(level);
			
			sender.addChatMessage(new ChatComponentText("Changed Kamui level to " + ExtendedPlayer.get(player).getKamuiLevel()));
			return;
		}
		
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args) {
		if (args.length < 2)
			return autoComplete;
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] string, int i) {
		return false;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

}
