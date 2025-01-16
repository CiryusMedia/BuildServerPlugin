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

        Entity marker = player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        marker.addScoreboardTag(strings[0] + "_marker");

        int playerX = player.getLocation().getBlockX();
        int playerY = player.getLocation().getBlockY();
        int playerZ = player.getLocation().getBlockZ();

        player.getWorld().getBlockAt(playerX, playerY - 1, playerZ).setType(Material.RED_WOOL);

        player.sendMessage("Summoned a new marker \"" + strings[0] + "\"");

        return true;
    }
}
