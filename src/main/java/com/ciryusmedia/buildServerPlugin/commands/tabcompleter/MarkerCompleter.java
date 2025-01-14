package com.ciryusmedia.buildServerPlugin.commands.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MarkerCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        List<String> list = new ArrayList<>();

        Bukkit.getWorld("world").getEntities().forEach(entity -> {
            Set<String> tags = entity.getScoreboardTags();
            tags.forEach(tag -> {
                if (tag.contains("_marker")) {
                    if (!list.contains("tag")) {
                        list.add(tag.replace("_marker", ""));
                    }
                }
            });
        });

        return list;
    }

}
