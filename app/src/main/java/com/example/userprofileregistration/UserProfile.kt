package com.example.userprofileregistration

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val dob: String,
    val district: String,
    val mobile: String
): Serializable
