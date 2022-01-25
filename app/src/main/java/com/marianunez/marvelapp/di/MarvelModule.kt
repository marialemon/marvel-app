package com.marianunez.marvelapp.di

import com.marianunez.marvelapp.data.datasource.cloud.CharacterListDatasource
import com.marianunez.marvelapp.data.network.MarvelFactoryService
import com.marianunez.marvelapp.data.repository.CharacterListRepository
import com.marianunez.marvelapp.data.repository.CharacterListRepositoryImpl
import com.marianunez.marvelapp.domain.CharactersListUseCase
import com.marianunez.marvelapp.ui.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val marvelModule = module {
    single { MarvelFactoryService() }

    single { CharacterListDatasource(get()) }

    single <CharacterListRepository> { CharacterListRepositoryImpl(get()) } // cuando pida CharactersListRepository dame CharactersListRepositoryImpl

    single { CharactersListUseCase(get()) }

    viewModel {CharacterListViewModel(get())}
}