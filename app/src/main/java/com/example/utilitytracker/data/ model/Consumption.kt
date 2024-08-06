package com.example.utilitytracker.data.model


data class Consumption(
    val id: String,
    val type: String, // "water", "electricity", "gas", etc.
    val amount: Double,
    val date: String // O ajusta el tipo de fecha según tus necesidades
)