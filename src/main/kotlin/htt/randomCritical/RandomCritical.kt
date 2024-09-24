package htt.randomCritical

import listeners.PlayerCritListener
import org.bukkit.plugin.java.JavaPlugin

class RandomCritical : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(PlayerCritListener(), this)
        PlayerCritListener.est
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
