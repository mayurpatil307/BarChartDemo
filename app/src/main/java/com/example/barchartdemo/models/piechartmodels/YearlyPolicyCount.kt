package com.example.barchartdemo.models.piechartmodels


import com.google.gson.annotations.SerializedName

data class YearlyPolicyCount(
    @SerializedName("gcv")
    val gcv: Int,
    @SerializedName("mcv")
    val mcv: Int,
    @SerializedName("pcv")
    val pcv: Any,
    @SerializedName("private_car")
    val privateCar: Int,
    @SerializedName("two_wheeler")
    val twoWheeler: Int
)