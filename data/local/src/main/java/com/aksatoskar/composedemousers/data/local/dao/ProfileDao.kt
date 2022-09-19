package com.aksatoskar.composedemousers.data.local.dao

import androidx.room.*
import com.example.assignment.model.ProfileDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Query("SELECT * FROM ProfileDetailsEntity")
    fun getAll(): Flow<List<ProfileDetailsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(profiles: List<ProfileDetailsEntity>)

    @Update
    fun update(profileDetails: ProfileDetailsEntity)
}