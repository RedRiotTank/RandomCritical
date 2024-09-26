# RandomCritical ![Static Badge](https://img.shields.io/badge/Minecraft-%20v1.21-green) ![Static Badge](https://img.shields.io/badge/Plugin-blue) ![Static Badge](https://img.shields.io/badge/Easy%20to%20use-red) 

RandomCritical is a plugin for minecraft servers that will allow you to add randomized critical hits when players or mobs do damage, customizing the critical rate, damage, knockback and adding different particles to 

## Installing Plugin

To install RandomCritical on your Minecraft server you just have to copy the "RandomCritical-version.jar" file to your "/plugins" folder. Once you run the server with the plugin inside for the first time, it will generate a RandomCritical/ folder where you can find the configuration file for the plugin.

## Plugin Configuration

- Critical:
  - damageMultiplier [Float]: Base damage is multiplied by this value.
  - criticalRate [Float]: Probability of doing a critical. Being 0.0=0% and 1.0=100%.
  - knockBack [Float]: Number of blocks the critical will make the enemy knockback.
- Particles:
  - targetEnabled [Boolean]: Enables particles on damaged entity.
  - targetDensity [Integer]: Density of particles spawned on damaged entity.
  - targetParticle [String]: Used particle. [Check particle list here](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Particle.html#enum-constant-summary). An error will occur if the particle in cofig fill doesn't exists.

## Warranty and License ![Static Badge](https://img.shields.io/badge/License-GNU%20v3.0-green)

This project uses the GNU General Public License v3.0, if you have any questions about it you can consult the LICENSE file, I remember that this software runs without any type of guarantee and could contain bad practices or even errors.
