package com.marianunez.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marianunez.marvelapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharacterListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCharactersList()
    }


}