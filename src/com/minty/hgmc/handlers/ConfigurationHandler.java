package com.minty.hgmc.handlers;

import com.minty.hgmc.core.YTBroadcast;

/* 
 * Clase chargée de récupérer les informations nécessaire dans
 * la configuration du plugin.
 * */
public class ConfigurationHandler
{

	/** 
	 * @return The required rank NAME to broadcast a welcome message
	 * */
	public static String getRankName()
	{
		return YTBroadcast.getInstance().getConfig().getString("rank-name");
	}
	
	/** 
	 * @return The broadcast message to broadcast
	 * */
	public static String getBroadcast()
	{
		return YTBroadcast.getInstance().getConfig().getString("broadcast-message");
	}
	
	/** 
	 * @return A boolean
	 * */
	public static boolean removeBasicsMessage()
	{
		return YTBroadcast.getInstance().getConfig().getBoolean("remove-basic-message");
	}
	
}
