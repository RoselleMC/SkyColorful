package com.iroselle.minecraft.skycolorful

import org.bukkit.entity.Player

/**
 * SkyColorful
 * com.iroselle.minecraft.skycolorful.NMS
 *
 * @author Score2
 * @since 2022/12/30 15:09
 */
abstract class NMS {

    abstract fun sendRain(player: Player, parm: Float)

    abstract fun sendThunder(player: Player, parm: Float)
}