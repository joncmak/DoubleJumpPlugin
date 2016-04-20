package io.github.joncmak.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener
{
	private TestPlugin mPlugin;
	
	public BlockListener (TestPlugin pPlugin)
	{
		mPlugin = pPlugin;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent pEvent)
	{
		//pEvent.setCancelled(true);
		//replace block
		Block block = pEvent.getBlock();
		
		//TODO replace with config block
//		block.setType(Material.GLASS);
//		block.getState().update();
		
		Bukkit.getScheduler().runTaskLater(mPlugin, new Runnable()
		{
			@Override
			public void run()
			{
				block.setType(Material.BEDROCK);
				block.getState().update();
			}
		}, 20);
	}
}
