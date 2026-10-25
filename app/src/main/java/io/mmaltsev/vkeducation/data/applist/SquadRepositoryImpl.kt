package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.domain.applist.SquadInfo
import io.mmaltsev.vkeducation.domain.applist.SquadsRepository
import javax.inject.Inject

class SquadsRepositoryImpl @Inject constructor(
    private val dataSource: SquadsLocalDataSource,
) : SquadsRepository {

    // DTO из источника -> через Mapper -> Domain
    override suspend fun getSquads(): List<SquadInfo> =
        dataSource.getSquads().map { it.toDomain() }
}