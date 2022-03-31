package com.example.barchartdemo

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.barchartdemo.models.barchartmodels.BarChartData
import com.example.barchartdemo.models.barchartmodels.BarChartResponse
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter

class BarChartActivity : AppCompatActivity() {
    lateinit var barChart: BarChart
    lateinit var toggleButton: Button
    private var barDataSet: BarDataSet? = null

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        barChart = findViewById(R.id.bar_chart)
        toggleButton = findViewById(R.id.toggle_button)
        initiateBarChartForPremium()
        toggleButton.setOnClickListener(View.OnClickListener {
            if (barDataSet!!.label == "Total Premium") {
                initiateBarChartForPolicyCounts()
            } else {
                initiateBarChartForPremium()
            }
        })
    }

    private fun initiateBarChartForPremium() {
        barChart.xAxis.valueFormatter = MyXAxisFormatter()
        barChart.xAxis.isGranularityEnabled = true
        barChart.xAxis.granularity = 1f
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.axisRight.isEnabled = false
        val barData = BarData()
        barDataSet = BarDataSet(dataValuesForComprehensiveTotalPremium, "Total Premium")
        barDataSet!!.color = Color.RED
        barDataSet!!.valueTextSize = 12f
        barData.addDataSet(barDataSet)
        barChart.data = barData
        barChart.invalidate()
        barChart.notifyDataSetChanged()
    }

    private fun initiateBarChartForPolicyCounts() {
        barChart.xAxis.valueFormatter = MyXAxisFormatter()
        barChart.xAxis.isGranularityEnabled = true
        barChart.xAxis.granularity = 1f
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.axisRight.isEnabled = false
        val barData = BarData()
        barDataSet = BarDataSet(dataValuesForComprehensivePolicyCounts, "Policy Counts")
        barDataSet!!.color = Color.MAGENTA
        barDataSet!!.valueTextSize = 12f
        barData.addDataSet(barDataSet)
        barChart.data = barData
        barChart.invalidate()
        barChart.notifyDataSetChanged()
    }

    private val dataValuesForComprehensiveTotalPremium: ArrayList<BarEntry>
         get() {
            val dataValsForComprehensiveBarGraph = ArrayList<BarEntry>()
             dummyBarChartResponse.comprehensiveList.forEach {
                 val month = it.month
                 val totalPremium = it.totalPremium

                 when (month) {
                     "January" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             0f,
                             totalPremium.toFloat()
                         )
                     )
                     "February" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             1f,
                             totalPremium.toFloat()
                         )
                     )
                     "March" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             2f,
                             totalPremium.toFloat()
                         )
                     )
                     "April" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             3f,
                             totalPremium.toFloat()
                         )
                     )
                     "May" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             4f,
                             totalPremium.toFloat()
                         )
                     )
                     "June" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             5f,
                             totalPremium.toFloat()
                         )
                     )
                     "July" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             6f,
                             totalPremium.toFloat()
                         )
                     )
                     "August" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             7f,
                             totalPremium.toFloat()
                         )
                     )
                     "September" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             8f,
                             totalPremium.toFloat()
                         )
                     )
                     "October" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             9f,
                             totalPremium.toFloat()
                         )
                     )
                     "November" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             10f,
                             totalPremium.toFloat()
                         )
                     )
                     "December" -> dataValsForComprehensiveBarGraph.add(
                         BarEntry(
                             11f,
                             totalPremium.toFloat()
                         )
                     )
                 }
             }
            return dataValsForComprehensiveBarGraph
        }


    private val dataValuesForComprehensivePolicyCounts: ArrayList<BarEntry>
        get() {
            val dataValsForComprehensiveBarGraph = ArrayList<BarEntry>()
            dummyBarChartResponse.comprehensiveList.forEach {
                val month = it.month
                val policyCount = it.policyCount
                when (month) {
                    "January" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            0f,
                            policyCount.toFloat()
                        )
                    )
                    "February" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            1f,
                            policyCount.toFloat()
                        )
                    )
                    "March" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            2f,
                            policyCount.toFloat()
                        )
                    )
                    "April" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            3f,
                            policyCount.toFloat()
                        )
                    )
                    "May" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            4f,
                            policyCount.toFloat()
                        )
                    )
                    "June" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            5f,
                            policyCount.toFloat()
                        )
                    )
                    "July" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            6f,
                            policyCount.toFloat()
                        )
                    )
                    "August" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            7f,
                            policyCount.toFloat()
                        )
                    )
                    "September" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            8f,
                            policyCount.toFloat()
                        )
                    )
                    "October" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            9f,
                            policyCount.toFloat()
                        )
                    )
                    "November" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            10f,
                            policyCount.toFloat()
                        )
                    )
                    "December" -> dataValsForComprehensiveBarGraph.add(
                        BarEntry(
                            11f,
                            policyCount.toFloat()
                        )
                    )
                }

            }
            return dataValsForComprehensiveBarGraph
        }

    //dummy BarChartResponse
    private val dummyBarChartResponse: BarChartResponse
         get() {
            //dummy BarChartResponse
            val comprehensiveList = ArrayList<BarChartData>()
            comprehensiveList.add(BarChartData("January", 1, 10000.00))
            comprehensiveList.add(BarChartData("February", 2, 20000.00))
            comprehensiveList.add(BarChartData("March", 3, 40000.00))
            comprehensiveList.add(BarChartData("April", 4, 60000.00))
            comprehensiveList.add(BarChartData("May", 5, 50000.00))
            comprehensiveList.add(BarChartData("June", 5, 40000.00))
            val nonMotorList = ArrayList<BarChartData>()
            nonMotorList.add(BarChartData("January", 1, 10000.00))
            val thirdPartyList = ArrayList<BarChartData>()
            thirdPartyList.add(BarChartData("January", 1, 10000.00))
            return BarChartResponse(comprehensiveList, nonMotorList, thirdPartyList)
        }

    internal inner class MyXAxisFormatter : ValueFormatter() {
        private var labels: List<String>? = null
        override fun getAxisLabel(value: Float, axis: AxisBase): String {
            labels = labelStrings
            return labels!![value.toInt()]
        }

        private val labelStrings: List<String>
             get() {
                val labels: MutableList<String> = ArrayList()
                labels.add("January")
                labels.add("February")
                labels.add("March")
                labels.add("April")
                labels.add("May")
                labels.add("June")
                labels.add("July")
                labels.add("August")
                labels.add("September")
                labels.add("October")
                labels.add("November")
                labels.add("December")
                return labels
            }
    }
}