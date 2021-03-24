package com.eduardogeiselperes.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.eduardogeiselperes.roomdatabase.data.VehicleDatabase
import com.eduardogeiselperes.roomdatabase.repository.VehicleRepository
import com.eduardogeiselperes.roomdatabase.model.Vehicle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehicleViewModel (application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Vehicle>>
    private val repository: VehicleRepository

    init {
        val vehicleDao = VehicleDatabase.getDatabase(application).vehicleDao()
        repository = VehicleRepository(vehicleDao)
        readAllData = repository.readAllData
    }

    fun addVehicle(vehicle: Vehicle){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addVehicle(vehicle)
        }
    }

}