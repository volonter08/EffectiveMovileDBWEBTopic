package com.example.core_db.di

import android.content.Context
import androidx.room.Room
import com.example.core_db.db.AppDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    fun provideAppDB(context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, "app_db")
            .fallbackToDestructiveMigration().allowMainThreadQueries().addMigrations(AppDb.MIGRATION_1_2).build()
    }
}