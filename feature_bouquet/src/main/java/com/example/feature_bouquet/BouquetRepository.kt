package com.example.feature_bouquet

import androidx.lifecycle.LiveData
import com.example.core_data.model.Bouquet
import com.example.core_db.entities.toBouquetEntity
import javax.inject.Inject

class BouquetRepository @Inject constructor(val bouquetDao: com.example.core_db.dao.BouquetDao, val bouquetTypeFlavorCrossRefDao: com.example.core_db.dao.BouquetTypeFlavorCrossRefDao){
    val size: LiveData<Int> = bouquetDao.getSize()
    suspend fun addBouquet(bouquet: Bouquet){
        bouquetDao.insert(bouquet.toBouquetEntity())
    }
    suspend fun buyBouquet(bouquet: Bouquet){
        bouquetDao.remove(bouquet.toBouquetEntity())
    }
}