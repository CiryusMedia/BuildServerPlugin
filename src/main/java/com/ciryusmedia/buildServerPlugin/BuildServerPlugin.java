package com.ciryusmedia.buildServerPlugin;

import com.ciryusmedia.buildServerPlugin.commands.MarkerCommand;
import com.ciryusmedia.buildServerPlugin.commands.PlacemarkerCommand;
import com.ciryusmedia.buildServerPlugin.commands.TestCommand;
import com.ciryusmedia.buildServerPlugin.commands.tabcompleter.MarkerCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class BuildServerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("marker").setExecutor(new MarkerCommand());
        getCommand("marker").setTabCompleter(new MarkerCompleter());

        getCommand("placemarker").setExecutor(new PlacemarkerCommand());

        getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
