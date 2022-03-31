package com.example.barchartdemo.models.piechartmodels


import com.google.gson.annotations.SerializedName

data class YearlyPremiumForNonMotor(
    @SerializedName("health")
    val health: Double,
    @SerializedName("personal_accident")
    val personalAccident: Double,
    @SerializedName("travel")
    val travel: Double
)