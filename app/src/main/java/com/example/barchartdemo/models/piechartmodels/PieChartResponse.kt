package com.example.barchartdemo.models.piechartmodels


import com.google.gson.annotations.SerializedName

data class PieChartResponse(
    @SerializedName("comprehensive")
    val comprehensive: PieChartData,
    @SerializedName("non_motor")
    val nonMotor: PieChartDataForNonMotor,
    @SerializedName("third_party")
    val thirdParty: PieChartData
)