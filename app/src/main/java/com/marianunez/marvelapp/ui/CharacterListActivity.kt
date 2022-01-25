package com.marianunez.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.marianunez.marvelapp.databinding.ActivityMainBinding
import com.marianunez.marvelapp.ui.adapter.CharacterListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharacterListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI(){
        binding.characterList.layoutManager = LinearLayoutManager(this)
        binding.characterList.adapter = CharacterListAdapter()

        viewModel.getCharactersList()

        viewModel.characterList.observe(this, Observer { list ->
            (binding.characterList.adapter as CharacterListAdapter).setData(list)
        })
    }

}