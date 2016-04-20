package io.github.joncmak.TestPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerListener implements Listener
{
	private final PluginMain mPlugin;
	
	public PlayerListener(PluginMain pPlugin)
	{
		mPlugin = pPlugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent pEvent)
	{
		FileConfiguration fileConfig = mPlugin.getConfig();
		Player player = pEvent.getPlayer();
		if(player.hasPlayedBefore())
		{
			//send other msg
			String text = fileConfig.getString("join");
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
		}
		else
		{
			//send first msg
			String text = fileConfig.getString("firstjoin");
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
		}
	}
}
