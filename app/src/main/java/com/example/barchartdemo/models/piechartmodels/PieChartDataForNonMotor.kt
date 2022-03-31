package com.example.barchartdemo.models.piechartmodels


import com.google.gson.annotations.SerializedName

data class PieChartDataForNonMotor(
    @SerializedName("monthly_policy_count")
    val monthlyPolicyCount: Int,
    @SerializedName("monthly_premium")
    val monthlyPremium: Int,
    @SerializedName("yearly_policy_count")
    val yearlyPolicyCountForNonMotor: YearlyPolicyCountForNonMotor,
    @SerializedName("yearly_premium")
    val yearlyPremiumForNonMotor: YearlyPremiumForNonMotor
)