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
		
		String text = "";
		if(player.hasPlayedBefore())
		{
			//send other msg
			try
			{
				text = ChatColor.translateAlternateColorCodes('&', fileConfig.getString("join"));
			}
			catch (Exception ex)
			{
				// encountered error, send unformatted string
				text = fileConfig.getString("join");
			}
			finally
			{
				player.sendMessage(text);
			}
		}
		else
		{
			//send first msg
			try
			{
				text = ChatColor.translateAlternateColorCodes('&', fileConfig.getString("firstjoin"));
			}
			catch (Exception ex)
			{
				// encountered error, send unformatted string
				text = fileConfig.getString("firstjoin");
			}
			finally
			{
				player.sendMessage(text);
			}
		}
	}
}
