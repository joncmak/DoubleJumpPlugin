package io.github.joncmak.TestPlugin;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin
{
	private PlayerListener mPlayerListener = new PlayerListener(this);
	private BlockListener mBlockListener = new BlockListener(this);
	
	@Override
	public void onDisable()
	{
	}
	
	@Override
	public void onEnable()
	{	
		this.saveDefaultConfig();

		//setup listeners
		PluginManager pluginManager = this.getServer().getPluginManager();
		pluginManager.registerEvents(mPlayerListener, this);
		pluginManager.registerEvents(mBlockListener, this);		
	}

	@Override
	public boolean onCommand(CommandSender pSender, Command pCommand, String pLabel, String[] pArguments)
	{	
		FileConfiguration fileConfig = this.getConfig();
		
		if(pCommand.getName().equalsIgnoreCase("testplugin.reload"))
		{
			if(pArguments.length != 0)
			{
				return false;
			}
			this.reloadConfig();
			this.getLogger().info("configuration reloaded");
			return true;
		}
		else
		{
			if(pCommand.getName().equalsIgnoreCase("testplugin.block"))
			{
				if(pArguments.length != 1)
				{
					return false;
				}
				Material newMaterial = Material.getMaterial(pArguments[0].toUpperCase());
				if(null == newMaterial)
				{
					this.getLogger().info("invalid block");
					return false;
				}
				fileConfig.set("block", newMaterial.name());
				this.getLogger().info("block changed to " + newMaterial.name());
			}
			else if(pCommand.getName().equalsIgnoreCase("testplugin.join"))
			{
				if(pArguments.length < 1)
				{
					return false;
				}
				
				//Java 8 string method
//				String message = String.join(" ", pArguments);
				
				String message = StringUtils.join(pArguments, " ");
				fileConfig.set("join", message);
				this.getLogger().info("join message changed to " + message);
			}
			else if(pCommand.getName().equalsIgnoreCase("testplugin.firstjoin"))
			{
				if(pArguments.length < 1)
				{
					return false;
				}
				String message = StringUtils.join(pArguments, " ");
				fileConfig.set("join", message);
				this.getLogger().info("first join message changed to " + message);
			}
			this.saveConfig();
			return true;
		}
	}
}
