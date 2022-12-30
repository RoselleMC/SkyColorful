package com.iroselle.minecraft.skycolorful

import net.minecraft.server.v1_16_R3.PacketPlayOutGameStateChange
import org.bukkit.entity.Player
import taboolib.module.nms.sendPacket

/**
 * SkyColorful
 * com.iroselle.minecraft.skycolorful.NMSImpl
 *
 * @author Score2
 * @since 2022/12/30 15:10
 */
class NMSImpl : NMS() {

    override fun sendRain(player: Player, parm: Float) {
        player.sendPacket(PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.h, parm))
    }

    override fun sendThunder(player: Player, parm: Float) {
        player.sendPacket(PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.i, parm))
    }


}