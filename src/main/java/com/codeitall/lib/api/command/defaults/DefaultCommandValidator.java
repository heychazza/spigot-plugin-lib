package com.codeitall.lib.api.command.defaults;

import com.codeitall.lib.api.command.Command;
import com.codeitall.lib.api.command.CommandManager;
import com.codeitall.lib.api.command.CommandValidator;
import org.bukkit.command.CommandSender;

public class DefaultCommandValidator implements CommandValidator {
    public boolean canExecute(CommandSender sender, Command command) {
        if (!sender.hasPermission(command.permission())) {
            sender.sendMessage(CommandManager.getLocale().getNoPermission());
            return false;
        }

        return true;
    }
}
