package com.aksatoskar.composedemousers.data.local.model

import androidx.room.Entity

@Entity
data class IdEntity (
	val name : String? = null,
	val value : String?= null
)