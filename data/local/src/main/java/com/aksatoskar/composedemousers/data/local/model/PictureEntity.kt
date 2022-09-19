package com.aksatoskar.composedemousers.data.local.model

import androidx.room.Entity

@Entity
data class PictureEntity (
	val large : String? = null,
	val medium : String? = null,
	val thumbnail : String? = null
)