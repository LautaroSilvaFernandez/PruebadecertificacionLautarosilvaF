package com.example.pruebadecertificacionlautarosilvaf.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosDetails
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosList


@Dao

interface SignosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSignos(signosList: List<SignosList>)

    @Query("SELECT * FROM List_Signos ORDER BY id ASC")
    fun getAllSignos(): LiveData<List<SignosList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSignosDetail(signosDetails: SignosDetails)

    @Query("SELECT * FROM Details_Signos WHERE id = :id")
    fun getSignosDetailById(id: Int): LiveData<SignosDetails>

}