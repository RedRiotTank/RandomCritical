package listeners

import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.util.Vector
import kotlin.random.Random

class PlayerCritListener : Listener {

    companion object {
        val est = "static var"
    }

    private val CRIT_RATE = 0.2
    private val CRIT_KNOCKBACK = 1.5

    @EventHandler
    fun onPlayerHit(event: EntityDamageByEntityEvent) {

        if(event.entity is LivingEntity) {
            val hitter = event.damager as LivingEntity
            val target = event.entity as LivingEntity

            if(Random.nextDouble() < CRIT_RATE) {
                event.damage *= 2
                criticalKnockBack(target, hitter)
                hitter.sendMessage("x2 damage critical hit")
            }
        }
    }

    private fun criticalKnockBack(target: LivingEntity, hitter: LivingEntity) {
        val x = target.location.x - hitter.location.x
        val z = target.location.z - hitter.location.z

        var vector = Vector(x, 0.0, z)

        if (vector.length() > 0) vector = vector.normalize()

        vector = vector.multiply(CRIT_KNOCKBACK)

        vector.y = 0.5

        target.velocity = target.velocity.add(vector)
    }
}