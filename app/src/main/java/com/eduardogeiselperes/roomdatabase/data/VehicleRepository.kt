package com.eduardogeiselperes.roomdatabase.data

import androidx.lifecycle.LiveData

class VehicleRepository(private val vehicleDao: VehicleDao) {

    val readAllData: LiveData<List<Vehicle>> = vehicleDao.readAllData()

    suspend fun addVehicle(vehicle: Vehicle){
        vehicleDao.addVehicle(vehicle)
    }

}