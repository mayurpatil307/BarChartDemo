package com.example.barchartdemo.models.barchartmodels


import com.google.gson.annotations.SerializedName

data class BarChartResponse(
    @SerializedName("comprehensive")
    val comprehensiveList: List<BarChartData>,
    @SerializedName("non_motor")
    val nonMotorList: List<BarChartData>,
    @SerializedName("third_party")
    val thirdPartyList: List<BarChartData>
)