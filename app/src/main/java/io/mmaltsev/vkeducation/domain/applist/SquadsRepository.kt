package io.mmaltsev.vkeducation.domain.applist

interface SquadsRepository {
    suspend fun getSquads(): List<SquadInfo>
}