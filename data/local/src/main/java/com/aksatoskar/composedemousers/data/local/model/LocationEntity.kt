package com.aksatoskar.composedemousers.data.local.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class LocationEntity (
	val city : String? = null,
	val state : String? = null,
	val country : String? = null,
	val postcode : String? = null,
)