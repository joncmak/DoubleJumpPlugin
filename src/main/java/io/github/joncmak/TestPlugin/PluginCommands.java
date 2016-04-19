package io.github.joncmak.TestPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginCommands implements CommandExecutor
{
	private final TestPlugin mPlugin;
	
	public PluginCommands(TestPlugin pPlugin)
	{
		mPlugin = pPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender pSender, Command pCommand, String pLabel, String[] pArguments)
	{
		if(pSender instanceof Player)
		{
			Player player = (Player) pSender;
		}
		else
		{
			return false;
		}
		
		if(pCommand.getName().equalsIgnoreCase("reload"))
		{
			if(pArguments.length != 0)
			{
				//invalid
				return false;
			}
		}
		if(pCommand.getName().equalsIgnoreCase("block"))
		{
			if(pArguments.length != 1)
			{
				//invalid
				return false;
			}
		}
		if(pCommand.getName().equalsIgnoreCase("join"))
		{
			
		}
		if(pCommand.getName().equalsIgnoreCase("firstjoin"))
		{
			
		}
		
		return false;
	}

}
