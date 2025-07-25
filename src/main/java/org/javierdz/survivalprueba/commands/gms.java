package org.javierdz.survivalprueba.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.javierdz.survivalprueba.handlers.chatHandler;

public class gms implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player)) {
            commandSender.sendMessage("This command can only be used by players.");
            return true;
        }
        if (commandSender.hasPermission("survivalprueba.gamemode") || commandSender.isOp()) {
            commandSender.getServer().dispatchCommand(commandSender.getServer().getConsoleSender(), "gamemode survival " + strings[0]);
            commandSender.sendMessage(chatHandler.getColor("&aYou have set the player " + strings[0] + " to survival mode."));
            return true;
        } else {
            commandSender.sendMessage(chatHandler.getColor("&cYou do not have permission to use this command."));
        }
        return true;
    }
}
