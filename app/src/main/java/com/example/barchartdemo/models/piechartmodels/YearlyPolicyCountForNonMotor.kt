package com.example.barchartdemo.models.piechartmodels


import com.google.gson.annotations.SerializedName

data class YearlyPolicyCountForNonMotor(
    @SerializedName("health")
    val health: Int,
    @SerializedName("personal_accident")
    val personalAccident: Int,
    @SerializedName("travel")
    val travel: Int
)