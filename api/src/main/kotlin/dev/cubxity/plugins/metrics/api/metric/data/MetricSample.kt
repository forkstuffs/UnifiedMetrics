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

package dev.cubxity.plugins.metrics.api.metric.data

data class MetricSample(
    val type: MetricType,
    val name: String,
    val value: Double,
    val tags: Map<String, String> = emptyMap()
)

fun MetricSample(
    type: MetricType,
    name: String,
    value: Number,
    tags: Map<String, String> = emptyMap()
): MetricSample = MetricSample(type, name, value.toDouble(), tags)

fun CounterSample(name: String, value: Double, tags: Map<String, String> = emptyMap()): MetricSample =
    MetricSample(MetricType.Counter, name, value, tags)

fun CounterSample(name: String, value: Number, tags: Map<String, String> = emptyMap()): MetricSample =
    MetricSample(MetricType.Counter, name, value, tags)

fun GaugeSample(name: String, value: Double, tags: Map<String, String> = emptyMap()): MetricSample =
    MetricSample(MetricType.Gauge, name, value, tags)

fun GaugeSample(name: String, value: Number, tags: Map<String, String> = emptyMap()): MetricSample =
    MetricSample(MetricType.Gauge, name, value, tags)