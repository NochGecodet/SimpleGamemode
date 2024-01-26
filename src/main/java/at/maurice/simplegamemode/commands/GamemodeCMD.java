package at.maurice.simplegamemode.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player){
        if(strings.length == 1){
                Player p = (Player) commandSender;

                if(p.hasPermission("simplegamemode.use") || p.hasPermission("simplegamemode.*")){
                    int num = Integer.parseInt(strings[0]);


                    switch (num){

                        case 0:
                            p.setGameMode(GameMode.SURVIVAL);
                            break;
                        case 1:
                            p.setGameMode(GameMode.CREATIVE);
                            break;
                        case 2:
                            p.setGameMode(GameMode.ADVENTURE);
                            break;
                        case 3:
                            p.setGameMode(GameMode.SPECTATOR);
                            break;
                    }

                    p.sendMessage("§8[§6§lSimpleGM§8] §7Dein Gamemode wurde auf §e"+p.getGameMode()+" §7gesetzt.");
                }
        }
        if(strings.length == 2){
                Player p = (Player) commandSender;
                Player target = Bukkit.getPlayer(strings[1]);

                if(target != null){
                    if(p.hasPermission("simplegamemode.use.other") || p.hasPermission("simplegamemode.*")){
                        int num = Integer.parseInt(strings[0]);


                        switch (num){

                            case 0:
                                target.setGameMode(GameMode.SURVIVAL);
                                break;
                            case 1:
                                target.setGameMode(GameMode.CREATIVE);
                                break;
                            case 2:
                                target.setGameMode(GameMode.ADVENTURE);
                                break;
                            case 3:
                                target.setGameMode(GameMode.SPECTATOR);
                                break;
                        }

                        target.sendMessage("§8[§6§lSimpleGM§8] §7Dein Gamemode wurde auf §e"+p.getGameMode()+" §7gesetzt.");
                        p.sendMessage("§8[§6§lSimpleGM§8] §7Der Gamemode von §e"+target.getName()+"§7 wurde auf §e"+target.getGameMode()+" §7gesetzt.");
                    }
                }else p.sendMessage("§8[§6§lSimpleGM§8] §7Der Spieler ist nicht Online.");
            }
        }

        return false;
    }
}
