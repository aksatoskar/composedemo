package com.aksatoskar.composedemousers.data.local.model

import androidx.room.Entity

@Entity
data class NameEntity (
	val title : String? = null,
	val first : String? = null,
	val last : String? = null
)