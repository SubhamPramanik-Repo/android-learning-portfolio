package com.myapp.selfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val startDate: String?,
    val isJunior: Boolean,
    val immediateJoin: Boolean,
    val jobTitle: String?
) : Serializable {
    fun getFullJobDescription(): String {
        if (isJunior) {
            return "a Junior $jobTitle"
        } else {
            return "an $jobTitle"
        }
    }

    fun getAvailability() = if (immediateJoin) "immediately" else "from $startDate"
}