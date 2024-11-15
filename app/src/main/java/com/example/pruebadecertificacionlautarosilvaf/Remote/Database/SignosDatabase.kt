package com.example.pruebadecertificacionlautarosilvaf.Remote.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosDetails
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosList
import com.example.pruebadecertificacionlautarosilvaf.Dao.SignosDao


@Database(entities = [SignosList::class, SignosDetails::class], version = 1, exportSchema = false)
abstract class SignosDataBase : RoomDatabase() {


    abstract fun getSignosDao(): SignosDao

    companion object {


        @Volatile
        private var INSTANCE: SignosDataBase? = null

        fun getdatabase(context: Context): SignosDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SignosDataBase::class.java,
                    "Signos_database"
                )
                    .build()
                INSTANCE = instance

                return instance
            }
        }
}