package com.example.pruebadecertificacionlautarosilvaf

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pruebadecertificacionlautarosilvaf.Remote.Database.SignosDataBase
import kotlinx.coroutines.launch

import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosDetails
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosList

class SignosViewModel(application: Application) : AndroidViewModel(application) {

        private val repository: SignosRepository
        private var idSelected: Int = 0

        init {
            val bd = SignosDataBase.getdatabase(application)
            val Dao = bd.getSignosDao()
            repository = SignosRepository(Dao)
            viewModelScope.launch {
                repository.fetchList()
            }


        }

        fun getSignosList(): LiveData<List<SignosList>> = repository.SignosListLiveData




        fun getSignosDetailsByIdFromInternet(id: Int) = viewModelScope.launch {
            idSelected = id
            repository.fetchSignosDetails(id)

        }



        fun getSignosDetail(): LiveData<SignosDetails> = repository.getSignosDetailsById(idSelected)
    }

