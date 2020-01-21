package com.simplymerlin.fiber.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import com.simplymerlin.fiber.utils.ChatUtils;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

@CommandAlias("heal|fheal")
@Description("Heals you or others.")
public class HealCMD extends BaseCommand {

    @Default
    @CommandPermission("fiber.heal")
    public void onDefault(Player p) {
        p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
        p.setFoodLevel(20);
        p.setSaturation(10);
        p.setExhaustion(0F);
        for(PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        ChatUtils.send(p, "&bYou have been &3healed&b.");
    }

    @Default
    @CommandPermission("fiber.heal.others")
    @CommandCompletion("@players")
    public void onTarget(CommandSender sender, OnlinePlayer onlinetarget) {
        Player target = onlinetarget.player;
        if(target.getHealth() == 0) {
            ChatUtils.send(sender, "&bYou can't heal someone who is dead!");
            return;
        }
        target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
        target.setFoodLevel(20);
        target.setSaturation(10);
        target.setExhaustion(0F);
        for(PotionEffect effect : target.getActivePotionEffects()) {
            target.removePotionEffect(effect.getType());
        }
        ChatUtils.send(sender, "&3" + target.getName() + "&b has been &3healed&b.");
    }

}
