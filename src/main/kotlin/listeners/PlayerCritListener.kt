package listeners

import config.RCConfig
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.util.Vector
import kotlin.random.Random

class PlayerCritListener : Listener {

    @EventHandler
    fun onPlayerHit(event: EntityDamageByEntityEvent) {
        if (event.damager !is LivingEntity || event.entity !is LivingEntity) return
        if(Random.nextDouble() > RCConfig.criticalRate) return

        val hitter = event.damager as LivingEntity
        val target = event.entity as LivingEntity

        event.damage *= RCConfig.damageMultiplier
        criticalKnockBack(target, hitter)
        targetParticle(target)
    }

    private fun criticalKnockBack(target: LivingEntity, hitter: LivingEntity) {
        val x = target.location.x - hitter.location.x
        val z = target.location.z - hitter.location.z

        var vector = Vector(x, 0.0, z)

        if (vector.length() > 0) vector = vector.normalize()

        vector = vector.multiply(RCConfig.knockBackMultiplier)

        vector.y = 0.5

        target.velocity = target.velocity.add(vector)
    }

    private fun targetParticle(target: LivingEntity) {
        if (!RCConfig.particleTargetEnabled) return

        val world = target.world
        val location = target.location

        for (i in 0 until RCConfig.particleTargetDensity) {
            val offsetX = (Random.nextDouble() - 0.5) * 2
            val offsetY = Random.nextDouble()
            val offsetZ = (Random.nextDouble() - 0.5) * 2

            world.spawnParticle(
                    RCConfig.targetParticle,
                    location.x + offsetX,
                    location.y + offsetY + 1,
                    location.z + offsetZ,
                    1,
                    0.0, 0.0, 0.0,
                    0.0
            )
        }
    }
}