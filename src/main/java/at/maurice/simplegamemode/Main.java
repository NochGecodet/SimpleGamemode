package at.maurice.simplegamemode;

import at.maurice.simplegamemode.commands.GamemodeCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gm").setExecutor(new GamemodeCMD());
    }

    @Override
    public void onDisable() {
    }
}
