package com.example.feature_bouquet.di

import com.example.core_db.di.DaoModule
import com.example.core_db.di.DbModule
import dagger.Component

@Component( modules = [DaoModule::class,DbModule::class])
interface BouquetComponent {
}