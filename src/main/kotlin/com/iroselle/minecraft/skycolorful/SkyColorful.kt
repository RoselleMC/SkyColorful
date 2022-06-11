package com.iroselle.minecraft.skycolorful

import net.minecraft.server.v1_16_R3.PacketPlayOutGameStateChange
import org.bukkit.entity.Player
import taboolib.common.platform.Plugin
import taboolib.common.platform.command.command
import taboolib.common.platform.function.info
import taboolib.common.platform.function.pluginId
import taboolib.module.nms.sendPacket

object SkyColorful : Plugin() {

    override fun onEnable() {
        info("Successfully running ExamplePlugin!")

        command(pluginId, aliases = listOf("sc", "skyc")) {
            literal("rain") {
                dynamic {
                    execute<Player> { player, context, argument ->
                        val param = argument.toFloatOrNull() ?: return@execute player.sendMessage("§c$argument 不是一个浮点数, 请正确输入.")
                        player.sendPacket(PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.h, param))
                        player.sendMessage("§b雨天等级已修改为 $argument.")
                    }
                }
            }
            literal("thunder") {
                dynamic {
                    execute<Player> { player, context, argument ->
                        val param = argument.toFloatOrNull() ?: return@execute player.sendMessage("§c$argument 不是一个浮点数, 请正确输入.")
                        player.sendPacket(PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.i, param))
                        player.sendMessage("§e闪电等级已修改为 $argument.")
                    }
                }
            }
        }
    }
}