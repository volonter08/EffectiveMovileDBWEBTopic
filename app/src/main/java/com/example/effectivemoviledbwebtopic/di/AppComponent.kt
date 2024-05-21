package com.example.effectivemoviledbwebtopic.di

import android.content.Context
import com.example.core_network.di.NetworkModule
import com.example.effectivemoviledbwebtopic.MainActivity
import com.example.core_db.db.AppDb
import com.example.core_db.di.DaoModule
import com.example.core_db.di.DbModule
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Component(modules = [DbModule::class, DaoModule::class, NetworkModule::class])
@Singleton
interface AppComponent {
    val appDb: AppDb
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context):Builder
        @BindsInstance
        fun dbScope(scope:CoroutineScope):Builder
        fun build(): AppComponent
    }
    fun injectToActivity(activity:MainActivity)
}