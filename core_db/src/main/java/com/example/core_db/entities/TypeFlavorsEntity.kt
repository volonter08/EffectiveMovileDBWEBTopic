package com.example.core_db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core_data.model.TypeFlavor

@Entity
class TypeFlavorsEntity (
    @PrimaryKey
    val type:TypeFlavor,
    val amount:Int,
    @ColumnInfo(name = "country_produced")
    val countryProduced:String?
)