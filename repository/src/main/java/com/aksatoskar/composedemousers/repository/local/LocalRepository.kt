package com.aksatoskar.composedemousers.repository.local

import com.aksatoskar.composedemousers.core.model.*
import com.aksatoskar.composedemousers.core.repository.Either
import com.aksatoskar.composedemousers.core.repository.IRepository
import com.aksatoskar.composedemousers.data.local.dao.ProfileDao
import com.aksatoskar.composedemousers.data.local.model.*
import com.example.assignment.model.ProfileDetailsEntity
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Source of data of notes from from local database
 */
class LocalRepository @Inject constructor(
    private val profileDao: ProfileDao
) : IRepository {

    override suspend fun updateProfile(
        profileDetails: ProfileDetails
    ) {
        val nameEntity = NameEntity(
            title = profileDetails.name?.title,
            first = profileDetails.name?.first,
            last = profileDetails.name?.last,
        )
        val locationEntity = LocationEntity(
            city = profileDetails.location?.city,
            state = profileDetails.location?.state,
            country = profileDetails.location?.country,
            postcode = profileDetails.location?.postcode
        )

        val loginEntity = LoginEntity(
            uuid = profileDetails.login.uuid,
            username = profileDetails.login.username,
        )

        val dobEntity = DobEntity(
           date = profileDetails.dob?.date,
           age = profileDetails.dob?.age
        )

        val idEntity = IdEntity(
            name = profileDetails.id?.name,
            value = profileDetails.id?.value
        )

        val pictureEntity = PictureEntity(
            large = profileDetails.picture?.large,
            medium = profileDetails.picture?.medium,
            thumbnail = profileDetails.picture?.thumbnail,
        )


        val profileEntity = ProfileDetailsEntity(
            gender = profileDetails.gender,
            name = nameEntity,
            location = locationEntity,
            email = profileDetails.email,
            login = loginEntity,
            dob = dobEntity,
            phone = profileDetails.phone,
            cell = profileDetails.cell,
            id = idEntity,
            picture = pictureEntity,
            nat = profileDetails.nat,
            action = profileDetails.action
        )
        profileDao.update(profileEntity)
    }


    override fun getAllProfiles(): Flow<Either<List<ProfileDetails>>> = profileDao.getAll()
        .map { profiles -> profiles.map {profileDetailsEntity->

            val name = Name(
                title = profileDetailsEntity.name?.title,
                first = profileDetailsEntity.name?.first,
                last = profileDetailsEntity.name?.last,
            )
            val location = Location(
                city = profileDetailsEntity.location?.city,
                state = profileDetailsEntity.location?.state,
                country = profileDetailsEntity.location?.country,
                postcode = profileDetailsEntity.location?.postcode
            )

            val login = Login(
                uuid = profileDetailsEntity.login.uuid,
                username = profileDetailsEntity.login.username,
            )

            val dob = Dob(
                date = profileDetailsEntity.dob?.date,
                age = profileDetailsEntity.dob?.age
            )

            val id = Id(
                name = profileDetailsEntity.id?.name,
                value = profileDetailsEntity.id?.value
            )

            val picture = Picture(
                large = profileDetailsEntity.picture?.large,
                medium = profileDetailsEntity.picture?.medium,
                thumbnail = profileDetailsEntity.picture?.thumbnail,
            )

            ProfileDetails(
                gender = profileDetailsEntity.gender,
                name = name,
                location = location,
                email = profileDetailsEntity.email,
                login = login,
                dob = dob,
                phone = profileDetailsEntity.phone,
                cell = profileDetailsEntity.cell,
                id = id,
                picture = picture,
                nat = profileDetailsEntity.nat,
                action = profileDetailsEntity.action
            )
            }
        }
        .transform { profiles -> emit(Either.success(profiles)) }
        .catch { emit(Either.success(emptyList())) }

    /** Not needed (NO-OP) **/
    override fun fetchProfiles(id: Int): Flow<Either<List<ProfileDetails>>> = emptyFlow()

    override suspend fun insertAllProfiles(profiles: List<ProfileDetails>) = profiles.map {profileDetails->
        val nameEntity = NameEntity(
            title = profileDetails.name?.title,
            first = profileDetails.name?.first,
            last = profileDetails.name?.last,
        )
        val locationEntity = LocationEntity(
            city = profileDetails.location?.city,
            state = profileDetails.location?.state,
            country = profileDetails.location?.country,
            postcode = profileDetails.location?.postcode
        )

        val loginEntity = LoginEntity(
            uuid = profileDetails.login.uuid,
            username = profileDetails.login.username,
        )

        val dobEntity = DobEntity(
            date = profileDetails.dob?.date,
            age = profileDetails.dob?.age
        )

        val idEntity = IdEntity(
            name = profileDetails.id?.name,
            value = profileDetails.id?.value
        )

        val pictureEntity = PictureEntity(
            large = profileDetails.picture?.large,
            medium = profileDetails.picture?.medium,
            thumbnail = profileDetails.picture?.thumbnail,
        )

        ProfileDetailsEntity(
            gender = profileDetails.gender,
            name = nameEntity,
            location = locationEntity,
            email = profileDetails.email,
            login = loginEntity,
            dob = dobEntity,
            phone = profileDetails.phone,
            cell = profileDetails.cell,
            id = idEntity,
            picture = pictureEntity,
            nat = profileDetails.nat,
            action = profileDetails.action
        )
    }.let {
        profileDao.insertAll(it)
    }
}
