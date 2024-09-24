package htt.randomCritical

import listeners.PlayerCritListener
import org.bukkit.plugin.java.JavaPlugin

class RandomCritical : JavaPlugin() {

    private var damageMultiplier: Double = 2.0
    private var criticalRate: Double = 0.2
    private var knockbackMultiplier: Double = 1.5

    override fun onEnable() {
        loadConfig()

        server.pluginManager.registerEvents(PlayerCritListener(damageMultiplier, criticalRate, knockbackMultiplier), this)

        logger.info("RandomCritical Plugin Enabled with Configured Values")
    }

    override fun onDisable() {
        logger.info("RandomCritical Plugin Disabled")
    }

    private fun loadConfig() {
        saveDefaultConfig()

        damageMultiplier = config.getDouble("critical.damage_multiplier", 2.0)
        criticalRate = config.getDouble("critical.critical_rate", 0.2)
        knockbackMultiplier = config.getDouble("critical.knock_back", 1.5)
    }
}
