package com.example.core_db.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.core_data.model.Bouquet
import com.example.core_data.model.TypeFlavor

@Entity
data class BouquetEntity @JvmOverloads constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @Ignore val flavors:Map<com.example.core_data.model.TypeFlavor,Int>? = null
)
fun com.example.core_data.model.Bouquet.toBouquetEntity(): BouquetEntity {
    return BouquetEntity(
        id, flavors
    )
}