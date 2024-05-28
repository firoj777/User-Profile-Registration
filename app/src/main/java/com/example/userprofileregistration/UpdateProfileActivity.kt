package com.example.userprofileregistration

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class UpdateProfileActivity : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel
    private lateinit var userProfile: UserProfile

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var districtEditText: EditText
    private lateinit var mobileEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        userProfile = intent.getSerializableExtra("USER_PROFILE") as UserProfile

        nameEditText = findViewById(R.id.profileNameEt)
        emailEditText = findViewById(R.id.profileEmailEt)
        dobEditText = findViewById(R.id.profileDOBEt)
        districtEditText = findViewById(R.id.profileDistrictEt)
        mobileEditText = findViewById(R.id.profilemobileEt)

        populateFields()

        findViewById<Button>(R.id.updateBtn).setOnClickListener {
            updateUserProfile()
        }
    }

    private fun populateFields() {
        nameEditText.setText(userProfile.name)
        emailEditText.setText(userProfile.email)
        dobEditText.setText(userProfile.dob)
        districtEditText.setText(userProfile.district)
        mobileEditText.setText(userProfile.mobile)
    }

    private fun updateUserProfile() {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val dob = dobEditText.text.toString()
        val district = districtEditText.text.toString()
        val mobile = mobileEditText.text.toString()

        val updatedUserProfile = UserProfile(
            id = userProfile.id,
            name = name,
            email = email,
            dob = dob,
            district = district,
            mobile = mobile
        )

        profileViewModel.updateUserProfile(updatedUserProfile)

        finish()
    }
}