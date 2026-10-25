package io.mmaltsev.vkeducation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.mmaltsev.vkeducation.data.applist.SquadsRepositoryImpl
import io.mmaltsev.vkeducation.domain.applist.SquadsRepository

// Говорит Hilt: когда просят SquadsRepository, давай SquadsRepositoryImpl
@Module
@InstallIn(SingletonComponent::class)
abstract class SquadsModule {

    @Binds
    abstract fun bindSquadsRepository(impl: SquadsRepositoryImpl): SquadsRepository
}