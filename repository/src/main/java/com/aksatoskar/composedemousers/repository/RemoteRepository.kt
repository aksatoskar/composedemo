package com.aksatoskar.composedemousers.repository

import com.aksatoskar.composedemousers.core.model.ProfileDetails
import com.aksatoskar.composedemousers.core.repository.Either
import com.aksatoskar.composedemousers.core.repository.IRepository
import com.aksatoskar.composedemousers.data.remote.api.ApiService
import com.aksatoskar.composedemousers.data.remote.model.response.MatchProfileResponse
import com.aksatoskar.composedemousers.data.remote.util.getResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Source of data of notes from network
 */
@Singleton
class RemoteRepository @Inject internal constructor(
    private val profileService: ApiService
) : IRepository {

    /** Not needed (NO-OP) **/
    override suspend fun updateProfile(profileDetails: ProfileDetails) {}

    /** Not needed (NO-OP) **/
    override fun getAllProfiles(): Flow<Either<List<ProfileDetails>>> = emptyFlow()

    override fun fetchProfiles(id: Int): Flow<Either<List<ProfileDetails>>> = flow {
        val matchProfileResponse: MatchProfileResponse = profileService.getMatchProfiles(id).getResponse()

        val state = if (!matchProfileResponse.results.isNullOrEmpty()) {
            Either.success(matchProfileResponse.results!!)
        } else {
            Either.error("Can't sync latest notes")
        }

        emit(state)
    }.catch { emit(Either.error("Can't sync latest notes")) }

    /** Not needed (NO-OP) **/
    override suspend fun insertAllProfiles(notes: List<ProfileDetails>) {}
}
