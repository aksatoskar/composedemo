package com.aksatoskar.composedemousers.data.local.model

import androidx.room.Entity

@Entity
data class LoginEntity (
	val uuid : String,
	val username : String
)