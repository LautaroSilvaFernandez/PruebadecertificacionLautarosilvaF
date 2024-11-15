package com.example.pruebadecertificacionlautarosilvaf

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.pruebadecertificacionlautarosilvaf.Dao.SignosDao
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosDetails

class SignosRepository(private val SignosDao: SignosDao) {

    private val networkService = RetrofitSignos.retrofitInstance()

    val SignosListLiveData = SignosDao.getAllSignos()


    suspend fun fetchList() {
        val service = kotlin.runCatching { networkService.fetchSignosList() }

        service.onSuccess {
            when (it.code()) {
                in 200..299 -> it.body()?.let {

                    Log.d("Signos", it.toString())

                    SignosDao.insertAllSignos(fromInternetListSignosInt(it))

                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error", "${it.message}")
            }

        }

    }


    suspend fun fetchSignosDetails(id: Int): SignosDetails? {

        val service = kotlin.runCatching { networkService.fetchSignosDetail(id) }

        return service.getOrNull()?.body()?.let { Details ->

            val SignosDetail= fromInternetDetailSignosInt ( Details)

            SignosDao.insertSignosDetail(SignosDetail)
            SignosDetail
        }
    }

    fun getSignosDetailsById(id: Int): LiveData<SignosDetails> {
        return SignosDao.getSignosDetailById(id)
    }
}