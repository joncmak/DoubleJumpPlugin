package io.github.joncmak.TestPlugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin
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
		PluginManager pluginManager = this.getServer().getPluginManager();
		pluginManager.registerEvents(mPlayerListener, this);
		pluginManager.registerEvents(mBlockListener, this);
		
		//getCommand("TestPlugin").setExecutor(new PluginCommands(this));
	}
}
