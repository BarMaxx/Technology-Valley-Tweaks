package ru.hollowhorizon.technologyvalley

import com.aetherteam.aether.world.LevelUtil
import net.minecraft.server.level.ServerPlayer
import net.minecraft.stats.StatType
import net.minecraft.stats.Stats
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent
import net.neoforged.neoforge.event.entity.player.PlayerSetSpawnEvent

@Mod(TechnologyValley.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
object TechnologyValley {
    const val ID = "technologyvalley"

    @SubscribeEvent
    fun onChangeDimension(event: PlayerLoggedInEvent) {
        val player = event.entity as? ServerPlayer ?: return

        if (player.stats.getValue(Stats.CUSTOM[Stats.PLAY_TIME]) == 0) {
            val aether = player.server.getLevel(LevelUtil.destinationDimension()) ?: return

            val pos = aether.getSafeSpawn(player.blockPosition())

            player.teleportTo(aether, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), player.xRot, player.yHeadRot)
            aether.setDefaultSpawnPos(pos, 0f)
            player.setRespawnPosition(LevelUtil.destinationDimension(), pos, 0f, true, false)
        }
    }
}
