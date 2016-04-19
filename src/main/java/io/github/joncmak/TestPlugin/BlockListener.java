package io.github.joncmak.TestPlugin;

import org.bukkit.Location;
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
		//replace block
		Block block = pEvent.getBlock();
		Location location = block.getLocation();
		
		//TODO replace with config block
		location.getBlock().setType(Material.BEDROCK);
	}
}
