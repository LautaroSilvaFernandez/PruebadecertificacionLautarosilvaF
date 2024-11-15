package com.example.pruebadecertificacionlautarosilvaf


import com.example.pruebadecertificacionlautarosilvaf.Remote.DetailSignosInt
import com.example.pruebadecertificacionlautarosilvaf.Remote.ListSignosInt
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface SignosApi {

    @GET("Signos")
    suspend fun fetchSignosList(): Response<List<ListSignosInt>>


    // seleccionar uno

    @GET("Signos{id}")
    suspend fun fetchSignosDetail(@Path("id") id: Int): Response<DetailSignosInt>
}