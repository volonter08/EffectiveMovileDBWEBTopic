package com.example.core_db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.core_db.entities.BouquetEntity
import com.example.core_db.entities.BouquetTypeFlavorCrossRef

@Dao
abstract class BouquetDao(val appDb: com.example.core_db.db.AppDb) {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun internalInsert(bouquet: BouquetEntity)

    @Transaction
    open suspend fun insert(bouquet: BouquetEntity) {
        val typeFlavorsDao = appDb.typeFlavorsDao()
        val bouquetTypeFlavorCrossRefDao = appDb.bouquetTypeFlavorCrossRefDao()
        internalInsert(bouquet)
        bouquet.flavors?.entries?.forEach { entry ->
            bouquetTypeFlavorCrossRefDao.insert(
                BouquetTypeFlavorCrossRef(bouquet.id, entry.key, entry.value)
            )
            typeFlavorsDao.increaseCount(entry.key, entry.value)
        }
    }

    @Query("DELETE FROM BouquetEntity WHERE id == :bouquetId ")
    abstract suspend fun internalRemove(bouquetId: Int)

    @Transaction
    open suspend fun remove(bouquet: BouquetEntity) {
        val typeFlavorsDao = appDb.typeFlavorsDao()
        internalInsert(bouquet)
        bouquet.flavors?.entries?.forEach { entry ->
            typeFlavorsDao.reduceCount(entry.key, entry.value)
        }
    }

    @Query("SELECT COUNT(*) FROM BouquetEntity")
    abstract fun getSize(): LiveData<Int>
}