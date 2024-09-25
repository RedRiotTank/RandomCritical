package htt.randomCritical

import config.RCConfig
import listeners.PlayerCritListener
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class RandomCritical : JavaPlugin() {


    override fun onEnable() {
        saveDefaultConfig()
        RCConfig.initialize(config)

        server.pluginManager.registerEvents(PlayerCritListener(), this)

        logger.info("RandomCritical Plugin Enabled with Configured Values")
    }

    override fun onDisable() {
        logger.info("RandomCritical Plugin Disabled")
    }


}
