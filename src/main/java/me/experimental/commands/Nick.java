package me.experimental.commands;
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

import me.experimental.Main;
import me.experimental.files.Data;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Nick extends Command {

    public Data data;
    protected Nick(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String cmd, @NotNull String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player)commandSender;
            if(player.hasPermission(Objects.requireNonNull(Main.getPlugin(Main.class).getConfig().getString("perm-to-nick")))) {
                if(player.hasPermission(Objects.requireNonNull(Main.getPlugin(Main.class).getConfig().getString("perm-to-use-color")))) {
                    String nick = ChatColor.translateAlternateColorCodes('&', args[0]);
                    data.get().set("nicks"+player.getName(), nick);
                } else {
                    data.get().set("nicks"+player.getName(), args[0]);
                }
            } else {
                String prefix = Main.getPlugin(Main.class).getConfig().getString("prefix");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+"&cYou do not have permission to do that."));
            }
        } else {
            String prefix = Main.getPlugin(Main.class).getConfig().getString("prefix");
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+"&cYou are not a player."));

        }
        return false;
    }

}
