package com.marianunez.marvelapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.marvelapp.R
import com.marianunez.marvelapp.commons.loadImageByUrl
import com.marianunez.marvelapp.databinding.ListCharacterBinding
import com.marianunez.marvelapp.domain.model.CharacterModel

class CharacterListAdapter : RecyclerView.Adapter<CharacterListViewHolder>() {

    private var characterList: List<CharacterModel> = emptyList()
    fun setData(list: List<CharacterModel>) {
        characterList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_character, parent, false)
        return CharacterListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int = characterList.size
}


class CharacterListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ListCharacterBinding.bind(view)

    fun bind(item: CharacterModel) {
        binding.apply {
            characterName.text = item.name
            characterDescription.text = item.description
            characterImg.loadImageByUrl(item.imgUrl)
        }
    }

}