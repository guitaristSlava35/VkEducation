package io.mmaltsev.vkeducation.domain.applist

import javax.inject.Inject

class GetSquadsUseCase @Inject constructor(
    private  val repository: SquadsRepository
) {
    suspend operator fun invoke(): List<SquadInfo> = repository.getSquads()
}