package com.example.pruebadecertificacionlautarosilvaf

import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosDetails
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosList
import com.example.pruebadecertificacionlautarosilvaf.Remote.DetailSignosInt
import com.example.pruebadecertificacionlautarosilvaf.Remote.ListSignosInt


fun fromInternetListSignosInt(SignosList: List<ListSignosInt>): List<SignosList> {

    return SignosList.map {
        SignosList(

            id = it.id,
            nombre =it.nombre,
            fechas =it.fechas,
            elemento =it.elemento,
            planetaRegente = it.planetaRegente,
            simbolo =it.simbolo,
            color =it.color,
            logo =it.logo
        )
    }
}


fun fromInternetDetailsSignos(detailSignosInt: DetailSignosInt): SignosDetails {

    return SignosDetails(

        id = detailSignosInt.id,
        nombre =detailSignosInt.nombre,
        fechas =detailSignosInt.fechas,
        elemento =detailSignosInt.elemento,
        planetaRegente = detailSignosInt.planetaRegente,
        simbolo = detailSignosInt.simbolo,
        color = detailSignosInt.color,
        logo =detailSignosInt.logo

    )