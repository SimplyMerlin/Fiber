package com.simplymerlin.fiber;

import co.aikar.commands.PaperCommandManager;
import com.simplymerlin.fiber.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;

public final class Fiber extends JavaPlugin {

    @Override
    public void onEnable() {

        //Commands
        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new FlyCMD());
        manager.registerCommand(new HealCMD());
        manager.registerCommand(new GamemodeCMD());
        manager.registerCommand(new FeedCMD());
        manager.registerCommand(new KillCMD());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
