package com.example.effectivemoviledbwebtopic

import android.app.Application
import com.example.effectivemoviledbwebtopic.di.AppComponent
import com.example.effectivemoviledbwebtopic.di.DaggerAppComponent
import com.example.core_db.entities.TypeFlavorsEntity
import com.example.core_data.model.TypeFlavor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class App : Application() {
    val scope = CoroutineScope(Dispatchers.Default)
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder().context(this).dbScope(scope).build()
        enumValues<TypeFlavor>().forEach { typeFlavor->
            scope.launch {
              appComponent.appDb.typeFlavorsDao().insert(
                  TypeFlavorsEntity(typeFlavor, 0, "Russia")
              )
            }
        }
        super.onCreate()
    }
}