package me.experimental;
/*
    
    This file is licensed by ExperimentalX. Unless you have
    specific permission from ExperimentalX, you are not
    permitted to touch this file at all. It is open
    sourced so you can see how I did it, not for
    you to copy off of it.
    
    Please. If you are trying to learn, don't copy off of
    other people, see what they did, and try to do it better.
    See if you can figure out why it works the way it does.
    
    This was written by ExperimentalX on 7/5/2022 for
    NickPlaceholders
    
*/

import me.experimental.papi.PAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        this.saveDefaultConfig();

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().severe("You are missing PlaceholderAPI. This plugin will not function.");
        } else {
            Bukkit.getPluginManager().registerEvents(this, this);
            new PAPI(this).register();
        }

        getLogger().info("Loaded NickPlaceholders");
    }

    public void onDisable() {
        getLogger().info("Cya on the other side :)");
    }
}
