package com.mwsa.domain.util

import kotlinx.datetime.Instant

interface Entity {
    val id: String
    val createdAt: Instant?
}

data class EntityDomain(
    override val id: String,
    override val createdAt: Instant?,
) : Entity

fun buildEntity(
    id: String,
    createdAt: Instant? = null,
): Entity = EntityDomain(id, createdAt)
