package com.simplymerlin.fiber.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import com.simplymerlin.fiber.utils.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("feed|ffeed")
@Description("Fills your or other's hunger bar.")
public class FeedCMD extends BaseCommand {

    @Default
    @CommandPermission("fiber.feed")
    public void onDefault(Player p) {
        p.setFoodLevel(20);
        p.setSaturation(10);
        p.setExhaustion(0F);
        ChatUtils.send(p, "&bYour hunger bar has been filled.");
    }
    @Default
    @CommandPermission("fiber.feed.other")
    @CommandCompletion("@players")
    public void onDefault(CommandSender sender, OnlinePlayer onlineplayer) {
        Player target = onlineplayer.player;
        target.setFoodLevel(20);
        target.setSaturation(10);
        target.setExhaustion(0F);
        ChatUtils.send(sender, "&3" + target.getName() + "&b's hunger bar has been filled.");
    }

}
