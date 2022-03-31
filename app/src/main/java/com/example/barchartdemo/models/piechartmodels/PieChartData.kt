package com.example.barchartdemo.models.piechartmodels

import com.google.gson.annotations.SerializedName

data class PieChartData(
    @SerializedName("monthly_policy_count")
    val monthlyPolicyCount: Int,
    @SerializedName("monthly_premium")
    val monthlyPremium: Int,
    @SerializedName("yearly_policy_count")
    val yearlyPolicyCount: YearlyPolicyCount,
    @SerializedName("yearly_premium")
    val yearlyPremium: YearlyPremium
)