package io.github.jessepayneee;

import org.bukkit.Bukkit;
import org.zeroturnaround.javarebel.ClassEventListener;
import org.zeroturnaround.javarebel.ReloaderFactory;


/**
 * Shows a message each time JRebel updates a class.
 */
public class JRebelEventHandler {

    public JRebelEventHandler(){
        init();
    }

    private static void init(){

        ReloaderFactory.getInstance().addClassLoadListener(new ClassEventListener() {
            public void onClassEvent(int i, Class aClass) {
                Bukkit.getServer().broadcastMessage(Main.getPrefix() + aClass.getName() + " Loaded!");
            }

            public int priority() {
                return 0;
            }
        });

        ReloaderFactory.getInstance().addClassReloadListener(new ClassEventListener() {
            public void onClassEvent(int i, Class aClass) {
                Bukkit.getServer().broadcastMessage(Main.getPrefix() + aClass.getName() + " Reloaded!");
            }

            public int priority() {
                return 0;
            }
        });

        Bukkit.getLogger().info("===============================================");
        Bukkit.getLogger().info("Rebel-Logger has been fully enabled.");
        Bukkit.getLogger().info("===============================================");

    }
}
