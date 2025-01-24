package com.ciryusmedia.buildServerPlugin.connection;

import com.ciryusmedia.buildServerPlugin.BuildServerPlugin;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ServerConnector {

    static Plugin plugin = BuildServerPlugin.getPlugin(BuildServerPlugin.class);

    public static void sendPlayerToServer(String server, Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server.toLowerCase());
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    public static void sendPlayerToChallengeServer(Player player) {
        sendPlayerToServer("lobby", player);
    }

}
