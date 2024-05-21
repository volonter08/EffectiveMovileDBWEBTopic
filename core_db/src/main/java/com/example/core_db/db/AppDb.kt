package com.example.core_db.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.core_db.dao.TypeFlavorsDao
import com.example.core_db.dao.BouquetDao
import com.example.core_db.dao.BouquetTypeFlavorCrossRefDao
import com.example.core_db.entities.TypeFlavorsEntity
import com.example.core_db.entities.BouquetEntity
import com.example.core_db.entities.BouquetTypeFlavorCrossRef

@Database(entities = [BouquetEntity::class,TypeFlavorsEntity::class,BouquetTypeFlavorCrossRef::class], version = 2)
abstract class AppDb : RoomDatabase() {
    abstract fun bouquetDao(): BouquetDao
    abstract fun typeFlavorsDao():TypeFlavorsDao
    abstract fun bouquetTypeFlavorCrossRefDao():BouquetTypeFlavorCrossRefDao
    companion object{
        val MIGRATION_1_2 = object :Migration(1,2){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE TypeFlavorsEntity ADD COLUMN country_produced TEXT")
            }

        }
    }
}