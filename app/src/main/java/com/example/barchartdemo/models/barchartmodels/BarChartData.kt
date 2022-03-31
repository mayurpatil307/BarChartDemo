package com.example.barchartdemo.models.barchartmodels


import com.google.gson.annotations.SerializedName

data class BarChartData(
    @SerializedName("month")
    val month: String,
    @SerializedName("policy_count")
    val policyCount: Int,
    @SerializedName("total_premium")
    val totalPremium: Double
)