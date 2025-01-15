package com.ciryusmedia.buildServerPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MarkerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length == 0) {
            commandSender.sendMessage("Too few arguments");
            return true;
        }

        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("Need to be a player to use this command");
            return true;
        }

        if (!Bukkit.getWorld("world").getEntities().stream().anyMatch(e -> e.getScoreboardTags().contains(strings[0]))
        && !Bukkit.getWorld("world").getEntities().stream().anyMatch(e -> e.getScoreboardTags().contains(strings[0] + "_marker"))) {
            commandSender.sendMessage("Marker " + strings[0] + " does not exist");
            return true;
        }

        String tag = strings[0];

        if (!tag.contains("_marker")) {
            tag += "_marker";
        }

        String finalTag = tag;
        Entity marker = Bukkit.getWorld("world").getEntities().stream().filter(e -> e.getScoreboardTags().contains(finalTag)).findFirst().get();

        player.teleport(marker);

        return true;
    }

}
