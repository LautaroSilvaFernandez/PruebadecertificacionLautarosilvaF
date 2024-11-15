package com.example.pruebadecertificacionlautarosilvaf

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebadecertificacionlautarosilvaf.Entitys.SignosList
import com.example.pruebadecertificacionlautarosilvaf.databinding.SignoslistBinding


class ListsAdapter : RecyclerView.Adapter<ListsAdapter.viewholder>() {

    private var listSignos= listOf<SignosList>()
    private val selectedSignos = MutableLiveData<SignosList>()


    fun selectedSignos(): LiveData<SignosList> = selectedSignos




    inner class viewholder(private val binding: SignoslistBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(list: SignosList) {

            Glide.with(binding.imageRv).load(list.imagen).centerCrop().into(binding.imageRv)
            binding.textNameRV.text = "Name :{list.nombre}"
            binding.textTipoRV.text = "Type:{list.tipo}"
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View) {

            selectedSignos.value = listSignos[bindingAdapterPosition]
            Log.d("ONCLICK", bindingAdapterPosition.toString())
        }

    }

    fun update(list: List<SignosList>) {
        listSignos = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(SignoslistBinding.inflate(LayoutInflater.from(parent.context)))
    }



    override fun getItemCount(): Int = listSignos.size


    // POSICIONA LOS ELEMENTOS
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.bind(listSignos[position])
    }

}