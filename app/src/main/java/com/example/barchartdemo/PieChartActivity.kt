package com.example.barchartdemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.barchartdemo.models.piechartmodels.*
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.DefaultValueFormatter

class PieChartActivity : AppCompatActivity() {
    lateinit var pieChart: PieChart
    lateinit var toggleButton: Button
    private var pieDataSet: PieDataSet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)
        pieChart = findViewById(R.id.pie_chart)
        toggleButton = findViewById(R.id.toggle_button_pie)

        toggleButton.setOnClickListener(View.OnClickListener {
            if (pieChart.getCenterText() == "Comprehensive Premium") {
                showPieChartForComprehensivePolicyCounts()
            } else {
                showPieChartForComprehensivePremium()
            }
        })
        showPieChartForComprehensivePremium()
        //showPieChartForNonMotor();
    }

    private fun showPieChartForComprehensivePremium() {
        val label = "Comprehensive Premium"
        val pieChartResponse = dummyPieChartResponse
        populatePieChartWithComprehensivePremium(pieChartResponse)
        initPieChart(label)
    }

    private fun showPieChartForComprehensivePolicyCounts() {
        val label = "Comprehensive Policy Count"
        val pieChartResponse = dummyPieChartResponse
        populatePieChartWithComprehensivePolicyCounts(pieChartResponse)
        initPieChart(label)
    }

    private fun showPieChartForNonMotor() {
        val label = "PieChartForNonMotor"
        val pieChartResponse = dummyPieChartResponse
        populatePieChartForNonMotorPremium(pieChartResponse)
        initPieChart(label)
    }

    private fun initPieChart(label: String) {
        pieDataSet!!.valueTextSize = 12f
        pieDataSet!!.valueTextColor = Color.WHITE
        pieDataSet!!.colors = colorsForPieChart
        pieDataSet!!.valueFormatter = DefaultValueFormatter(0)

        pieChart.centerText = label
        pieChart.setCenterTextSize(16f)
        pieChart.setCenterTextColor(Color.BLUE)
        pieChart.legend.isEnabled = false
        val pieData = PieData(pieDataSet)
        pieData.setDrawValues(true)
        pieData.setDrawValues(true)
        pieChart.description.text = ""
        pieChart.description.textColor =
            ContextCompat.getColor(this, android.R.color.holo_red_dark) //the color of the font
        pieChart.data = pieData
        pieChart.notifyDataSetChanged()
        pieChart.invalidate()
    }

    private fun populatePieChartWithComprehensivePolicyCounts(pieChartResponse: PieChartResponse) {
        val pieDataMap: MutableMap<String, Int> = HashMap()
        pieDataMap["GCV"] = pieChartResponse.comprehensive.yearlyPolicyCount.gcv
        pieDataMap["MCV"] = pieChartResponse.comprehensive.yearlyPolicyCount.mcv
        pieDataMap["PCV"] = pieChartResponse.comprehensive.yearlyPolicyCount.gcv
        pieDataMap["Private Cars"] = pieChartResponse.comprehensive.yearlyPolicyCount.privateCar
        pieDataMap["Two Wheelers"] = pieChartResponse.comprehensive.yearlyPolicyCount.twoWheeler
        val pieEntries = ArrayList<PieEntry>()
        for (type in pieDataMap.keys) {
            pieEntries.add(PieEntry(pieDataMap[type]!!.toFloat(), type))
        }
        pieDataSet = PieDataSet(pieEntries, "")
    }

    private fun populatePieChartWithComprehensivePremium(pieChartResponse: PieChartResponse) {
        val pieDataMap: MutableMap<String, Int> = HashMap()
        pieDataMap["GCV"] = pieChartResponse.comprehensive.yearlyPremium.gcv.toInt()
        pieDataMap["MCV"] = pieChartResponse.comprehensive.yearlyPremium.mcv.toInt()
        pieDataMap["PCV"] = pieChartResponse.comprehensive.yearlyPremium.gcv.toInt()
        pieDataMap["Private Cars"] = pieChartResponse.comprehensive.yearlyPremium.privateCar
        pieDataMap["Two Wheelers"] = pieChartResponse.comprehensive.yearlyPremium.twoWheeler
        val pieEntries = ArrayList<PieEntry>()
        for (type in pieDataMap.keys) {
            pieEntries.add(PieEntry(pieDataMap[type]!!.toFloat(), type))
        }
        pieDataSet = PieDataSet(pieEntries, "")
    }

    private fun populatePieChartForNonMotorPremium(pieChartResponse: PieChartResponse) {
        //initializing data
        val pieDataMap: MutableMap<String, Int> = HashMap()
        pieDataMap["Health"] = pieChartResponse.nonMotor.yearlyPremiumForNonMotor.health.toInt()
        pieDataMap["Accident"] =
            pieChartResponse.nonMotor.yearlyPremiumForNonMotor.personalAccident.toInt()
        pieDataMap["Travel"] = pieChartResponse.nonMotor.yearlyPremiumForNonMotor.travel.toInt()
        val pieEntries = ArrayList<PieEntry>()
        for (type in pieDataMap.keys) {
            pieEntries.add(PieEntry(pieDataMap[type]!!.toFloat(), type))
        }
        pieDataSet = PieDataSet(pieEntries, "")
    }

    private val colorsForPieChart: ArrayList<Int>
        get() {
            val colors = ArrayList<Int>()
            colors.add(Color.parseColor("#304567"))
            colors.add(Color.parseColor("#309967"))
            colors.add(Color.parseColor("#476567"))
            colors.add(Color.parseColor("#890567"))
            colors.add(Color.parseColor("#a35567"))
            colors.add(Color.parseColor("#ff5f67"))
            colors.add(Color.parseColor("#3ca567"))
            return colors
        }
    //dummy PieChartResponse

    //COMPREHENSIVE
    private val dummyPieChartResponse: PieChartResponse
        get() {
            //dummy PieChartResponse

            //COMPREHENSIVE
            val yearlyPremiumForComprehensive = YearlyPremium(100.00, 200.00, 150.00, 20, 50)
            val yearlyPolicyCountForComprehensive = YearlyPolicyCount(4, 5, 8, 12, 6)
            val pieChartDataForComprehensive =
                PieChartData(0, 0, yearlyPolicyCountForComprehensive, yearlyPremiumForComprehensive)

            //NON-MOTOR
            val yearlyPremiumForNonMotor = YearlyPremiumForNonMotor(100.00, 200.00, 150.00)
            val yearlyPolicyCountForNonMotor = YearlyPolicyCountForNonMotor(4, 5, 8)
            val pieChartDataForNonMotor = PieChartDataForNonMotor(
                0,
                0,
                yearlyPolicyCountForNonMotor,
                yearlyPremiumForNonMotor
            )

            //THIRD PARTY
            val yearlyPremiumForThirdParty = YearlyPremium(100.00, 200.00, 150.00, 20, 50)
            val yearlyPolicyCountForThirdParty = YearlyPolicyCount(4, 5, 8, 12, 6)
            val pieChartDataForThirdParty =
                PieChartData(0, 0, yearlyPolicyCountForThirdParty, yearlyPremiumForThirdParty)
            return PieChartResponse(
                pieChartDataForComprehensive,
                pieChartDataForNonMotor,
                pieChartDataForThirdParty
            )
        }
}