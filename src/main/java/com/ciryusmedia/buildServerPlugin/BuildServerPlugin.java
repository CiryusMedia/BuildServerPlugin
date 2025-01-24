package com.ciryusmedia.buildServerPlugin;

import com.ciryusmedia.buildServerPlugin.commands.ChallengeCommand;
import com.ciryusmedia.buildServerPlugin.commands.MarkerCommand;
import com.ciryusmedia.buildServerPlugin.commands.PlacemarkerCommand;
import com.ciryusmedia.buildServerPlugin.commands.TestCommand;
import com.ciryusmedia.buildServerPlugin.commands.tabcompleter.MarkerCompleter;
import com.ciryusmedia.buildServerPlugin.listener.PlayerJoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BuildServerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("challenge").setExecutor(new ChallengeCommand());

        getCommand("marker").setExecutor(new MarkerCommand());
        getCommand("marker").setTabCompleter(new MarkerCompleter());

        getCommand("placemarker").setExecutor(new PlacemarkerCommand());

        getCommand("test").setExecutor(new TestCommand());

        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(), this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
