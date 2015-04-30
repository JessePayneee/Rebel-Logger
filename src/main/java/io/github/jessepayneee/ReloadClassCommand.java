package io.github.jessepayneee;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.zeroturnaround.javarebel.ReloaderFactory;

public class ReloadClassCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length < 1){
            sender.sendMessage(Main.getPrefix() + ChatColor.RED + "Not enough arguments!");
            sender.sendMessage(Main.getPrefix() + ChatColor.RED + "/rclass <path.to.class.Class>");
            return true;
        }

        Class clazz = null;

        try{
            clazz = Class.forName(args[0]);
        }catch(ClassNotFoundException | NoClassDefFoundError e) {

            sender.sendMessage(Main.getPrefix() + ChatColor.RED + "\"" + args[0] + "\" is not a valid Class.");
            return true;
        }

        if(clazz == null) {
            sender.sendMessage(Main.getPrefix() + "clazz is null...?");
            return true;
        }

        ReloaderFactory.getInstance().reinitClass(clazz);
        Bukkit.getServer().broadcastMessage(Main.getPrefix() + clazz.getName() + " Reloaded!");
        return true;
    }
}
