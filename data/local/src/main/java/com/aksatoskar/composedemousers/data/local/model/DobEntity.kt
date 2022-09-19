package com.aksatoskar.composedemousers.data.local.model

import androidx.room.Entity

@Entity
data class DobEntity (
	val date : String? = null,
	val age : Int? = null
)