package me.experimental.papi;
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

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.experimental.Main;
import me.experimental.files.Data;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PAPI extends PlaceholderExpansion {
    private final Main plugin;
    public PAPI(Main plugin) {
        this.plugin = plugin;
    }
    private Data data;
    @Override
    public @NotNull String getIdentifier() {
        return "nickplace";
    }

    @Override
    public @NotNull String getAuthor() {
        return "ExperimentalX";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0-SNAPSHOT";
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        if(params.equalsIgnoreCase("nick")) {
            String username = player.getName();
            return (data.get().isSet("nicks"+username) ? data.get().getString("nicks."+username) : username);
        }
        return null;
    }
}
