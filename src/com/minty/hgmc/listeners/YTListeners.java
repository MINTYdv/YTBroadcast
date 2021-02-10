package com.minty.hgmc.listeners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.minty.hgmc.handlers.ConfigurationHandler;

import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/* 
 * Classe chargée de récupérer les events de connexion des joueurs
 * */
public class YTListeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player player = e.getPlayer();
		PermissionUser permissionUser = PermissionsEx.getUser(player);
		World world = player.getLocation().getWorld();
		
		if(permissionUser.getGroups("world").length < 1) {
			return;
		}
		
		List<PermissionGroup> list = Arrays.asList(permissionUser.getGroups(world.getName()));
		PermissionGroup group = PermissionsEx.getPermissionManager().getGroup(ConfigurationHandler.getRankName());
		
		if(group == null)
		{
			System.out.println("ERREUR: Impossible de trouver un groupe avec le nom de " + ConfigurationHandler.getRankName());
			return;
		}
		
		if(list.contains(group))
		{
			String broadcastMsg = ConfigurationHandler.getBroadcast();
			String prefix = group.getPrefix(world.getName()).replace("&", "§");
			Bukkit.broadcastMessage(broadcastMsg.replace("<player>", player.getName()).replace("&", "§").replace("<rank>", prefix));
		}
		
		if(ConfigurationHandler.removeBasicsMessage()) {
			e.setJoinMessage("");
		}
	}
	
}
