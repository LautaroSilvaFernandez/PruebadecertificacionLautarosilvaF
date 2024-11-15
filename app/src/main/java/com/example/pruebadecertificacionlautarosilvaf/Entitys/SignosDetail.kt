package com.example.pruebadecertificacionlautarosilvaf.Entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Details_Signos")
data class SignosDetails(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val fechas: String,
    val elemento: String,
    val planetaRegente: String,
    val simbolo: String,
    val color: String,
    val logo: String
)