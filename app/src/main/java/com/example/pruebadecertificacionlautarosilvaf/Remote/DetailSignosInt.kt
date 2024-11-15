package com.example.pruebadecertificacionlautarosilvaf.Remote



    data class DetailSignosInt(

        val id: Int,
        val nombre: String,
        val fechas: String,
        val elemento: String,
        val planetaRegente: String,
        val simbolo: String,
        val color: String,
        val fortalezas: List<String>,
        val debilidades: List<String>,
        val descripcion: String,
        val compatibilidad: List<String>,
        val imagen: String
    )

