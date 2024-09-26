package config

import org.bukkit.Particle
import org.bukkit.configuration.file.FileConfiguration

object RCConfig {
    private lateinit var config: FileConfiguration

    //Critical
    var damageMultiplier = 2.0
    var criticalRate = 0.2
    var knockBackMultiplier = 1.5

    //Particles - target
    var particleTargetEnabled = true
    var particleTargetDensity = 10
    var targetParticle = Particle.CRIT

    fun initialize(configuration: FileConfiguration) {
        config = configuration
        loadConfig()
    }

    private fun loadConfig() {
        //Critical
        damageMultiplier = config.getDouble("critical.damageMultiplier")
        criticalRate = config.getDouble("critical.criticalRate")
        knockBackMultiplier = config.getDouble("critical.knockBack")

        //Particles - target
        particleTargetEnabled = config.getBoolean("particles.targetEnabled")
        particleTargetDensity = config.getInt("particles.targetDensity")

        val targetParticleName = config.getString("particles.targetParticle")!!
        targetParticle = Particle.valueOf(targetParticleName)


    }
}
