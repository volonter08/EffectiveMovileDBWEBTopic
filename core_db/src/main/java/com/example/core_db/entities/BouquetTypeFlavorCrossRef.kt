package com.example.core_db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.core_data.model.TypeFlavor

@Entity(primaryKeys = ["bouquetId","typeFlavor"], foreignKeys = [ForeignKey(
    entity = BouquetEntity::class,
    parentColumns = ["id"],
    childColumns = ["bouquetId"],
    onDelete = ForeignKey.CASCADE
), ForeignKey(
    entity = TypeFlavorsEntity::class,
    parentColumns = ["type"],
    childColumns = ["typeFlavor"],
    onDelete = ForeignKey.CASCADE
)])
data class BouquetTypeFlavorCrossRef(
    val bouquetId:Int,
    val typeFlavor: TypeFlavor,
    val count:Int
)