package com.minty.hgmc.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.minty.hgmc.listeners.YTListeners;

public class YTBroadcast extends JavaPlugin {
	
	private static YTBroadcast instance;
	
	@Override
	public void onEnable()
	{
		System.out.println("[YTBroadcast] Plugin activé !");
		saveDefaultConfig();
		
		registerReferences();
		registerListeners();
	}
	
	private void registerReferences()
	{
		instance = this;
	}
	
	private void registerListeners()
	{
		Bukkit.getServer().getPluginManager().registerEvents(new YTListeners(), this);
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("[YTBroadcast] Plugin désactivé !");
	}
	
	/* 
	 * Getters & Setters
	 * */
	
	public static YTBroadcast getInstance() {
		return instance;
	}
	
}
