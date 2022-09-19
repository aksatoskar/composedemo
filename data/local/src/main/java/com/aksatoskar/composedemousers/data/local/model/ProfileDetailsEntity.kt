package com.example.assignment.model

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aksatoskar.composedemousers.data.local.model.*


@Entity
data class ProfileDetailsEntity (
    val gender : String? = null,
    @Embedded
	val name : NameEntity? = null,
    @Embedded
	val location : LocationEntity? = null,
    val email : String? = null,
    @NonNull
	@Embedded
	@PrimaryKey
	val login : LoginEntity,
    @Embedded
	val dob : DobEntity? = null,
    val phone : String? = null,
    val cell : String? = null,
    @Embedded
	val id : IdEntity? = null,
    @Embedded
	val picture : PictureEntity? = null,
    val nat : String? = null,
    var action: Int? = null
)