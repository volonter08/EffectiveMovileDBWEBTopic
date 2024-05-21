package com.example.core_db.di

import com.example.core_db.dao.BouquetDao
import com.example.core_db.dao.BouquetTypeFlavorCrossRefDao
import com.example.core_db.dao.TypeFlavorsDao
import com.example.core_db.db.AppDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule{
    @Provides
    @Singleton
    fun provideBouquetDao(appDb: AppDb): BouquetDao = appDb.bouquetDao()
    @Provides
    @Singleton
    fun provideAllFlavorsDao(appDb: AppDb): TypeFlavorsDao = appDb.typeFlavorsDao()
    @Provides
    @Singleton
    fun provideBouquetTypeFlavorsCrossRef(appDb: AppDb): BouquetTypeFlavorCrossRefDao = appDb.bouquetTypeFlavorCrossRefDao()
}