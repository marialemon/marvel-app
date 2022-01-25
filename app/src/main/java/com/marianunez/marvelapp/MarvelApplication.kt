package com.marianunez.marvelapp

import android.app.Application
import com.marianunez.marvelapp.di.marvelModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            loadKoinModules(marvelModule)
        }
    }

}