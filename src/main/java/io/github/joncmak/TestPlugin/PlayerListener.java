package io.github.joncmak.TestPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener
{
	private final TestPlugin mPlugin;
	
	public PlayerListener(TestPlugin pPlugin)
	{
		mPlugin = pPlugin;
	}
	
	/*
	 * TODO: replace messages with config message
	 * add support for colour codes
	 */
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent pEvent)
	{
		Player player = pEvent.getPlayer();
		if(player.hasPlayedBefore())
		{
			//send other msg
			player.sendMessage("welcome back");
			mPlugin.getLogger().info(pEvent.getPlayer().getName() + " joined");
		}
		else
		{
			//send first msg
			player.sendMessage("welcome to the server");
			mPlugin.getLogger().info(pEvent.getPlayer().getName() + " joined first");
		}
	}
}
