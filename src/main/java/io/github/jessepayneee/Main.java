package io.github.jessepayneee;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    JRebelEventHandler eHandler;

    @Override
    public void onEnable(){

        try {
            // Check if the JRebel SDK is accessible
            Class.forName("org.zeroturnaround.javarebel.ReloaderFactory");
            Class.forName("org.zeroturnaround.javarebel.ClassEventListener");

            eHandler = new JRebelEventHandler();
            this.getCommand("rclass").setExecutor(new ReloadClassCommand());

        } catch(ClassNotFoundException | NoClassDefFoundError e) {
            Bukkit.getLogger().warning("===============================================");
            Bukkit.getLogger().warning("It appears JRebel has not been configured correctly, and as a result, Rebel-Logger was not able to load.");
            Bukkit.getLogger().warning("===============================================");
        } finally{
             Bukkit.getServer().getServicesManager().unregister(this);
             return;
        }
    }

    private static String prefix = ChatColor.GREEN.toString() + ChatColor.BOLD + "J"
            + ChatColor.WHITE.toString() + ChatColor.BOLD + "Rebel" + "> " + ChatColor.GRAY;

    public static String getPrefix(){
        return prefix;
    }

}
