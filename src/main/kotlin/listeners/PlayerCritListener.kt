package listeners

import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.util.Vector
import kotlin.random.Random

class PlayerCritListener(
        private val damageMultiplier: Double,
        private val criticalRate: Double,
        private val knockbackMultiplier: Double
) : Listener {



    @EventHandler
    fun onPlayerHit(event: EntityDamageByEntityEvent) {

        if(event.entity is LivingEntity) {
            val hitter = event.damager as LivingEntity
            val target = event.entity as LivingEntity

            if(Random.nextDouble() < criticalRate) {
                event.damage *= damageMultiplier
                criticalKnockBack(target, hitter)
                hitter.sendMessage("x " + damageMultiplier + " damage critical hit")
            }
        }
    }

    private fun criticalKnockBack(target: LivingEntity, hitter: LivingEntity) {
        val x = target.location.x - hitter.location.x
        val z = target.location.z - hitter.location.z

        var vector = Vector(x, 0.0, z)

        if (vector.length() > 0) vector = vector.normalize()

        vector = vector.multiply(knockbackMultiplier)

        vector.y = 0.5

        target.velocity = target.velocity.add(vector)
    }
}