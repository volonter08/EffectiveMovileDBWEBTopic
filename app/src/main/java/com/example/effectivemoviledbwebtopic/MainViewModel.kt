package com.example.effectivemoviledbwebtopic

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core_data.model.Bouquet
import com.example.core_network.GoogleApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

class MainViewModel(
    val bouquetRepository: com.example.feature_bouquet.BouquetRepository,
    val googleApiService: GoogleApiService
) : ViewModel() {
    val countBouquets: LiveData<Int> = bouquetRepository.size

    init {
        viewModelScope.launch {
            googleApiService.get()
            withContext(Dispatchers.IO) {
                bouquetRepository.addBouquet(
                    Bouquet.Builder().addId(1).addRedRose(10).addWhiteRoses(2).addTulips(3).build()
                )
                bouquetRepository.addBouquet(
                    Bouquet.Builder().addId(2).addLilies(32).addLotuses(3).build()
                )
            }
        }
    }
}

@Singleton
class MainViewModelFactory @Inject constructor(
    val bouquetRepository: com.example.feature_bouquet.BouquetRepository,
    val googleApiService: GoogleApiService
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(bouquetRepository, googleApiService) as T
    }

}