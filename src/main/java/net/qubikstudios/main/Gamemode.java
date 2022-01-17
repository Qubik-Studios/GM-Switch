package net.qubikstudios.main;

import net.kyori.adventure.text.Component;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Gamemode extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("gm")).setExecutor(this);
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            if (p.isOp() || p.hasPermission("gamemode.switch")) {
                if (args.length == 1) {
                    switch (args[0]) {
                        case "0" -> {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(Component.text("§8§l[§bGM Sw§ki§r§btch§8§l] §6You have switched your Gamemode to §aSurvival"));
                        }
                        case "1" -> {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(Component.text("§8§l[§bGM Sw§ki§r§btch§8§l] §6You have switched your Gamemode to §aCreative"));
                        }
                        case "2" -> {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(Component.text("§8§l[§bGM Sw§ki§r§btch§8§l] §6You have switched your Gamemode to §aAdventure"));
                        }
                        case "3" -> {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(Component.text("§8§l[§bGM Sw§ki§r§btch§8§l] §6You have switched your Gamemode to §aSpectator"));
                        }
                        default -> {
                            p.sendMessage(Component.text("§8§l[§bGM Sw§ki§r§btch§8§l] §cCan't find the Gamemode!"));
                        }
                    }
                }
            }
        }
        return false;
    }
}
