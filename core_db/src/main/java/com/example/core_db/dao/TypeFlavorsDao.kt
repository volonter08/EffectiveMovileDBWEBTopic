package com.example.core_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_db.entities.TypeFlavorsEntity

@Dao
interface TypeFlavorsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(allFlavorsEntity: TypeFlavorsEntity)
    @Delete
    fun remove(allFlavorsEntity: TypeFlavorsEntity)
    @Query( "UPDATE TypeFlavorsEntity SET amount = amount + :increasedCount WHERE type==:typeFlavor")
    fun increaseCount(typeFlavor: com.example.core_data.model.TypeFlavor, increasedCount:Int)
    @Query( "UPDATE TypeFlavorsEntity SET amount = amount - :reducedCount WHERE type==:typeFlavor")
    fun reduceCount(typeFlavor: com.example.core_data.model.TypeFlavor, reducedCount:Int)
    @Query("SELECT * FROM TypeFlavorsEntity WHERE type == :typeFlavor  ")
    suspend fun getTypeFlavorsEntity(typeFlavor: com.example.core_data.model.TypeFlavor): List<TypeFlavorsEntity>
}