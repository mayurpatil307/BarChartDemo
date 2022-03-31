package com.example.barchartdemo.models.piechartmodels


import com.google.gson.annotations.SerializedName

data class YearlyPremium(
    @SerializedName("gcv")
    val gcv: Double,
    @SerializedName("mcv")
    val mcv: Double,
    @SerializedName("pcv")
    val pcv: Double,
    @SerializedName("private_car")
    val privateCar: Int,
    @SerializedName("two_wheeler")
    val twoWheeler: Int
)