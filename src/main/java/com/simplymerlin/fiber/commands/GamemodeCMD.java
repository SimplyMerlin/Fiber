package com.simplymerlin.fiber.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import com.simplymerlin.fiber.utils.Chat;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("gm|gamemode|fgm|fgamemode")
@Description("Changes your or other's gamemode.")
public class GamemodeCMD extends BaseCommand {

    @Subcommand("creative|1")
    @CommandAlias("gmc|creative|fgmc|fcreative")
    @CommandPermission("fiber.gamemode.creative")
    public void onCreative(Player p) {
        p.setGameMode(GameMode.CREATIVE);
        Chat.send(p, "&bYour gamemode has been changed to &3Creative&b.");
    }
    @Subcommand("survival|0")
    @CommandAlias("gms|survival|fgms|fsurvival")
    @CommandPermission("fiber.gamemode.survival")
    public void onSurvival(Player p) {
        p.setGameMode(GameMode.SURVIVAL);
        Chat.send(p, "&bYour gamemode has been changed to &3Survival&b.");
    }
    @Subcommand("adventure|2")
    @CommandAlias("gma|adventure|fgma|fadventure")
    @CommandPermission("fiber.gamemode.adventure")
    public void onAdventure(Player p) {
        p.setGameMode(GameMode.ADVENTURE);
        Chat.send(p, "&bYour gamemode has been changed to &3Adventure&b.");
    }
    @Subcommand("spectator|3")
    @CommandAlias("gmsp|spectator|fgmsp|fspectator")
    @CommandPermission("fiber.gamemode.spectator")
    public void onSpectator(Player p) {
        p.setGameMode(GameMode.SPECTATOR);
        Chat.send(p, "&bYour gamemode has been changed to &3Spectator&b.");
    }

    @Subcommand("creative|1")
    @CommandAlias("gmc|creative|fgmc|fcreative")
    @CommandPermission("fiber.gamemode.creative|fiber.gamemode.others")
    @CommandCompletion("@players")
    public void onCreativeOther(CommandSender sender, OnlinePlayer onlinetarget) {
        Player target = onlinetarget.player;
        target.setGameMode(GameMode.CREATIVE);
        Chat.send(sender, "&bThe gamemode of " + target.getName() + "&b has been changed to &3Creative&b.");
    }
    @Subcommand("survival|0")
    @CommandAlias("gms|survival|fgms|fsurvival")
    @CommandPermission("fiber.gamemode.survival|fiber.gamemode.others")
    @CommandCompletion("@players")
    public void onSurvivalOther(CommandSender sender, OnlinePlayer onlinetarget) {
        Player target = onlinetarget.player;
        target.setGameMode(GameMode.SURVIVAL);
        Chat.send(sender, "&bThe gamemode of " + target.getName() + "&b has been changed to &3Survival&b.");
    }
    @Subcommand("adventure|2")
    @CommandAlias("gma|adventure|fgma|fadventure")
    @CommandPermission("fiber.gamemode.adventure|fiber.gamemode.others")
    @CommandCompletion("@players")
    public void onAdventureOther(CommandSender sender, OnlinePlayer onlinetarget) {
        Player target = onlinetarget.player;
        target.setGameMode(GameMode.ADVENTURE);
        Chat.send(sender, "&bThe gamemode of " + target.getName() + "&b has been changed to &3Adventure&b.");
    }
    @Subcommand("spectator|3")
    @CommandAlias("gmsp|spectator|fgmsp|fspectator")
    @CommandPermission("fiber.gamemode.spectator|fiber.gamemode.others")
    @CommandCompletion("@players")
    public void onSpectatorOther(CommandSender sender, OnlinePlayer onlinetarget) {
        Player target = onlinetarget.player;
        target.setGameMode(GameMode.SPECTATOR);
        Chat.send(sender, "&bThe gamemode of " + target.getName() + "&b has been changed to &3Spectator&b.");
    }



}
