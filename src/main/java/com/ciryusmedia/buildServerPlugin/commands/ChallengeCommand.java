package com.ciryusmedia.buildServerPlugin.commands;

import com.ciryusmedia.buildServerPlugin.connection.ServerConnector;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChallengeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings[0].equalsIgnoreCase("train")) {
            //Teleport everyone
            Bukkit.getOnlinePlayers().stream().filter(player -> player.getScoreboardTags().contains("join_challenge")).forEach(ServerConnector::sendPlayerToChallengeServer);
        }
        return true;
    }
}
