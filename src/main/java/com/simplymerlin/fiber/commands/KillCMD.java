package com.simplymerlin.fiber.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import com.simplymerlin.fiber.utils.Chat;
import org.bukkit.entity.Player;

@CommandAlias("kill|fkill|murder|fmurder")
public class KillCMD extends BaseCommand {

    @Default
    @CommandAlias("suicide|fsuicide")
    @CommandPermission("fiber.suicide")
    void onSuicide(Player player) {

        player.setHealth(0F);
        Chat.send(player, "&bYou've killed yourself.");

    }

    @Default
    @CommandPermission("fiber.kill")
    @CommandCompletion("@players")
    void onKill(Player sender, OnlinePlayer target) {

        target.player.setHealth(0F);
        Chat.send(sender, "&bYou've killed &6" + target.player.getName() + "&b.");

    }

}
