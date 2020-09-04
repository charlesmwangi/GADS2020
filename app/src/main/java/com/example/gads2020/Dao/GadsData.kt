package com.example.gads2020.Dao

data class LearningLeaders(
    val results: List<Result>
)
data class Result(
    val name: String,
    val hours: Int,
    val country: String,
    val badgeUrl: String
)

