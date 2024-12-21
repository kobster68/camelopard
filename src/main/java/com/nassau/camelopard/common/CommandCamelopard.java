package com.nassau.camelopard.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandCamelopard implements ICommand {

	private final String COMMAND_NAME = "camelopard";
	private final String COMMAND_USAGE = "/camelopard";
	
	private final List alias;
	
	public CommandCamelopard() {
		this.alias = new ArrayList();
		this.alias.add(this.getCommandName());
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
	public void processCommand(ICommandSender sender, String[] string) {
		sender.addChatMessage(new ChatComponentText("Camelopard Command"));
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] string) {
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
