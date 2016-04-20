package io.github.joncmak.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener
{
	private PluginMain mPlugin;
	
	public BlockListener (PluginMain pPlugin)
	{
		mPlugin = pPlugin;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent pEvent)
	{
		Block block = pEvent.getBlock();
		
		Bukkit.getScheduler().runTaskLater(mPlugin, new Runnable()
		{
			@Override
			public void run()
			{
				String blockname = mPlugin.getConfig().getString("block").toUpperCase();
				Material newMaterial = Material.getMaterial(blockname) != null ? Material.getMaterial(blockname) : Material.BEDROCK;

				block.setType(newMaterial);
				block.getState().update();
			}
		}, 20);
	}
}
