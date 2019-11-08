package com.example.edz.kotlinapplication.data

/**
 * @author： zcs
 * @time：2019/11/8 on 12:47
 * @description：
 */
data class CalentarDayBean(
        val reason: String,
        val result: CalentarDayResult,
        val error_code: Int
)

data class CalentarDayResult(
        val data: CalentarDayData
)

data class CalentarDayData(
        val date: String,
        val weekday: String,
        val animalsYear: String,
        val suit: String,
        val avoid: String,
        val yearMonth: String,
        val holiday: String,
        val lunar: String,
        val lunarYear: String,
        val desc: String
)

class CalentarMonthBean
class CalentarYearBean

