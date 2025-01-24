package com.ciryusmedia.buildServerPlugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlacemarkerCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player) ) {
            commandSender.sendMessage("You must be a player to use this command.");
            return true;
        }

        if (strings.length < 0) {
            commandSender.sendMessage("Where name?");
            return true;
        }

        Entity marker = player.getWorld().spawnEntity(player.getLocation(), EntityType.MARKER);
        marker.addScoreboardTag(strings[0] + "_marker");

        player.sendMessage("Summoned a new marker \"" + strings[0] + "\"");

        return true;
    }
}
