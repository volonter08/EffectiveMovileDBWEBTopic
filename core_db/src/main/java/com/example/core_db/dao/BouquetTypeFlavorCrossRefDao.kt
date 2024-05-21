package com.example.core_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.core_db.entities.BouquetTypeFlavorCrossRef

@Dao
interface BouquetTypeFlavorCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bouquetTypeFlavorCrossRef: BouquetTypeFlavorCrossRef)
    @Delete
    fun remove(bouquetTypeFlavorCrossRef: BouquetTypeFlavorCrossRef)
}