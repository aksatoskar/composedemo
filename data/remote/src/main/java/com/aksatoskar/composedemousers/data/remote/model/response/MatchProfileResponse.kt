package com.aksatoskar.composedemousers.data.remote.model.response

import com.aksatoskar.composedemousers.core.model.ProfileDetails

data class MatchProfileResponse(
    val results: List<ProfileDetails>?
)