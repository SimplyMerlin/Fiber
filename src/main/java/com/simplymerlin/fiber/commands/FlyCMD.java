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

@CommandAlias("fly|ffly|flight|fflight")
@Description("Disables flight for you or others.")
public class FlyCMD extends BaseCommand {

    @Default
    @CommandPermission("fiber.fly")
    public void onDefault(Player p) {
        if(p.getAllowFlight()) {
            ChatUtils.send(p, "&bFlight has been &3disabled&b.");
        }else {
            ChatUtils.send(p, "&bFlight has been &3enabled&b.");
        }
        p.setAllowFlight(!p.getAllowFlight());
    }

    @Default
    @CommandPermission("fiber.fly.others")
    @CommandCompletion("@players")
    public void onTarget(CommandSender sender, OnlinePlayer onlinetarget) {
        Player target = onlinetarget.player;
        String tname = target.getName();
        if(target.getAllowFlight()) {
            ChatUtils.send(sender, "&bFlight has been &3disabled&b for &3" + tname + "&b.");
        }else {
            ChatUtils.send(sender, "&bFlight has been &3enabled&b for &3" + tname + "&b.");
        }
        target.setAllowFlight(!target.getAllowFlight());
    }

}
