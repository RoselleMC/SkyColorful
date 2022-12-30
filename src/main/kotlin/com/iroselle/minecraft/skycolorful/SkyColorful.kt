package com.iroselle.minecraft.skycolorful

import net.minecraft.server.v1_16_R3.PacketPlayOutGameStateChange
import org.bukkit.FluidCollisionMode
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import taboolib.common.platform.Plugin
import taboolib.common.platform.command.command
import taboolib.common.platform.function.info
import taboolib.common.platform.function.pluginId
import taboolib.common.platform.function.submit
import taboolib.module.nms.nmsProxy
import taboolib.module.nms.sendPacket
import java.util.UUID


object SkyColorful : Plugin() {

    override fun onEnable() {
        info("Successfully running ExamplePlugin!")
        submit {  }
        command(pluginId, aliases = listOf("sc", "skyc")) {
            literal("rain") {
                dynamic {
                    execute<Player> { player, context, argument ->
                        val param = argument.toFloatOrNull() ?: return@execute player.sendMessage("§c$argument 不是一个浮点数, 请正确输入.")
                        nmsProxy<NMS>().sendRain(player, param)
                        player.sendMessage("§b雨天等级已修改为 $argument.")
                    }
                }
            }
            literal("thunder") {
                dynamic {
                    execute<Player> { player, context, argument ->
                        val param = argument.toFloatOrNull() ?: return@execute player.sendMessage("§c$argument 不是一个浮点数, 请正确输入.")
                        nmsProxy<NMS>().sendThunder(player, param)
                        player.sendMessage("§e闪电等级已修改为 $argument.")
                    }
                }
            }
        }
    }
}