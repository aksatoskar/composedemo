package com.aksatoskar.composedemousers.core.model

data class ProfileDetails (
    val gender : String? = null,
	val name : Name? = null,
	val location : Location? = null,
    val email : String? = null,
	val login : Login,
	val dob : Dob? = null,
    val phone : String? = null,
    val cell : String? = null,
	val id : Id? = null,
	val picture : Picture? = null,
    val nat : String? = null,
    var action: Int? = null
)