package com.aksatoskar.composedemousers.core.repository

import com.aksatoskar.composedemousers.core.model.ProfileDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface IRepository {
    suspend fun updateProfile(profileDetails: ProfileDetails)

    fun getAllProfiles(): Flow<Either<List<ProfileDetails>>>

    fun fetchProfiles(id: Int): Flow<Either<List<ProfileDetails>>>

    suspend fun insertAllProfiles(notes: List<ProfileDetails>)
}