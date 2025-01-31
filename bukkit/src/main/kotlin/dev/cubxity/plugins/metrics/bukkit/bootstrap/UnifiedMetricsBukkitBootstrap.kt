/*
 *     UnifiedMetrics is a fully-featured metrics collection plugin for Minecraft servers.
 *     Copyright (C) 2021  Cubxity
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.cubxity.plugins.metrics.bukkit.bootstrap

import dev.cubxity.plugins.metrics.api.platform.PlatformType
import dev.cubxity.plugins.metrics.bukkit.BukkitSchedulerAdapter
import dev.cubxity.plugins.metrics.bukkit.UnifiedMetricsBukkitPlugin
import dev.cubxity.plugins.metrics.common.UnifiedMetricsBootstrap
import dev.cubxity.plugins.metrics.common.plugin.logger.JavaLogger
import org.bukkit.plugin.java.JavaPlugin
import java.nio.file.Path

@Suppress("MemberVisibilityCanBePrivate")
class UnifiedMetricsBukkitBootstrap : JavaPlugin(), UnifiedMetricsBootstrap {
    private val plugin = UnifiedMetricsBukkitPlugin(this)

    override val type: PlatformType
        get() = PlatformType.Bukkit

    override val version: String
        get() = description.version

    override val serverBrand: String
        get() = server.name

    override val dataDirectory: Path
        get() = dataFolder.toPath()

    override val configDirectory: Path
        get() = dataFolder.toPath()

    override val logger = JavaLogger(getLogger())

    override val scheduler = BukkitSchedulerAdapter(this)

    override fun onEnable() {
        plugin.enable()
    }

    override fun onDisable() {
        plugin.disable()
    }
}